# Codacy Detekt

This is the docker engine we use at Codacy to have [Detekt](https://github.com/arturbosch/detekt) support.
You can also create a docker to integrate the tool and language of your choice!
Check the **Docs** section for more information.

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ccdc504c39e44ae998bcc9e948c9fae3)](https://www.codacy.com/gh/codacy/codacy-detekt?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=codacy/codacy-detekt&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/codacy/codacy-detekt.svg?style=svg)](https://circleci.com/gh/codacy/codacy-detekt)

## Usage

You can create the docker by doing:

```bash
sbt stage && docker build -t codacy-detekt .
```

The docker is ran with the following command:

```bash
docker run -it -v $srcDir:/src  <DOCKER_NAME>:<DOCKER_VERSION>
```

## Docs

[Tool Developer Guide](https://support.codacy.com/hc/en-us/articles/207994725-Tool-Developer-Guide)

[Tool Developer Guide - Using Scala](https://support.codacy.com/hc/en-us/articles/207280379-Tool-Developer-Guide-Using-Scala)

## Test

We use the [codacy-plugins-test](https://github.com/codacy/codacy-plugins-test) to test our external tools integration.
You can follow the instructions there to make sure your tool is working as expected.

## Generate Docs

Change `detektVersion` in `build.sbt`

```sh
sbt "runMain codacy.detekt.DocGenerator"
```

## Agent Playbook: Updating This Repository End-to-End

This section is written for an AI coding agent (or a human) tasked with updating this repo — most commonly bumping the wrapped [Detekt](https://github.com/detekt/detekt) version, but also Kotlin/base-image/orb bumps. Follow it top to bottom; it tells you what to change, how to regenerate derived files, how to test locally, and how to interpret CI so you can iterate on failures without guessing.

### 1. What this repository is

This is a **Codacy engine**: a Scala wrapper (`src/main/scala/codacy/Engine.scala`, built on `codacy-engine-scala-seed`) that packages [Detekt](https://github.com/detekt/detekt), a static analysis tool for Kotlin, as a Docker image Codacy's platform can run against a customer's source code. The build itself is sbt/Scala (`build.sbt`), even though the tool being wrapped and analyzed is Kotlin — sbt pulls Detekt's Java/Kotlin artifacts as regular library dependencies. The `docs/` directory is not just documentation — it is **machine-consumed configuration**:

- `docs/patterns.json` — the full list of Detekt rules ("patterns") Codacy knows about, their category/level, and which are enabled by default (see the `defaultPatterns` list in the generator). Generated file, do not hand-edit.
- `docs/description/description.json` + `docs/description/*.md` — human-readable titles/descriptions per pattern, used in the Codacy UI. Generated file, do not hand-edit.
- `docs/tests/*.kt` and `docs/multiple-tests/*` — fixtures used by `codacy-plugins-test` to validate the engine actually produces the results it claims to for real Kotlin code samples.
- `docs/tool-description.md` — short blurb about the tool, hand-maintained.

All three generated artifacts above come from **`DocGenerator`** (`src/main/scala/codacy/detekt/DocGenerator.scala`), run via `sbt "runMain codacy.detekt.DocGenerator"`. It instantiates every Detekt rule provider in-process to enumerate rules for `patterns.json`, and additionally **clones the real `detekt/detekt` GitHub repo at tag `v<detektVersion>`** (see `getExtendedDescriptions`) to scrape rule-set source folders (`detekt-rules-*/src/main/**/*.kt`) for descriptions and code examples used in `docs/description/*.md`. Formatting-rule descriptions are built separately via `FormattingRulesDescriptionBuilder`, which uses the `detektCommit` value (see below) to fetch source at a specific commit. This means the generator needs **network access** and **git** installed locally, and it must be run with the *new* version already set in `build.sbt` so it clones/scrapes the matching Detekt tag.

### 2. Files that encode versions — check all of these on every update

| File | What it controls | What to check |
|---|---|---|
| `build.sbt` → `detektVersion` | Which Detekt release's libraries are compiled against, and which git tag (`v<version>`) `DocGenerator` clones for rule descriptions | Bump to the target version. Confirm a matching `v<version>` tag exists in [detekt/detekt](https://github.com/detekt/detekt/tags) and that all `io.gitlab.arturbosch.detekt` artifacts (`detekt-core`, `detekt-formatting`, `detekt-api`, `detekt-rules*`, `detekt-cli`, `detekt-generator`, etc. — there are ~25 of these, all driven by the same `detektVersion.value`) resolve at that version. |
| `build.sbt` → `detektCommit` | The exact commit SHA in `detekt/detekt` that `FormattingRulesDescriptionBuilder` fetches source from for formatting-rule descriptions | Update to the commit corresponding to the new `detektVersion` tag (e.g. `git rev-parse v<version>` against the detekt repo) whenever `detektVersion` changes. |
| `build.sbt` → `kotlinVersion` | Kotlin compiler version used to build/parse Kotlin sources | Check Detekt's own release notes/build for the Kotlin version it expects; bump to match if the new Detekt version requires a newer Kotlin. |
| `build.sbt` → `codacy-engine-scala-seed` dependency | Codacy's engine SDK/base library | Check Maven Central for newer versions if asked to update it; not tied to Detekt bumps. |
| `Dockerfile` → builder image (`sbtscala/scala-sbt:...`) and runtime image (`amazoncorretto:...`) | JDK/sbt/Scala the project builds and runs with | Only bump if the new Detekt/Kotlin version raises its minimum JDK requirement (past history shows both base images have been bumped for exactly this reason). |
| `.circleci/config.yml` → `codacy/base` orb | Shared CircleCI steps (checkout, versioning, docker publish, tagging) | Check the latest published version. |
| `.circleci/config.yml` → `codacy/plugins-test` orb | Runs `codacy-plugins-test` in CI after the image is built | Check the latest published version; this repo's CI history shows an orb bump was needed once to fix a broken `curl` binary in the test image. |

### 3. Step-by-step update procedure

1. **Bump `detektVersion` (and `detektCommit` to match) in `build.sbt`**, plus `kotlinVersion` if required, as scoped by the task.
2. **Regenerate the docs**: run `sbt "runMain codacy.detekt.DocGenerator"`. This requires network access (it clones `detekt/detekt`). Review the diff to `docs/patterns.json` and `docs/description/*.md` for new/removed/renamed rules and stale fixture references in `docs/tests/` and `docs/multiple-tests/`.
3. **Compile** with `sbt compile` and format with the project's `.scalafmt.conf` (`sbt scalafmt`) to catch build breakage from API changes in the new Detekt version early.
4. **Build the Docker image**: `sbt stage && docker build -t codacy-detekt .`
5. **Run `codacy-plugins-test` locally** before pushing — clone https://github.com/codacy/codacy-plugins-test and run its DockerTest commands against your local image tag (this repo's CI runs the equivalent as `codacy_plugins_test/run` with `run_multiple_tests: true`, exercising both `docs/tests/` and `docs/multiple-tests/`).
6. **Iterate on failures**, re-running only the relevant test command after each fix.
7. **Commit** the version bump(s) together with any regenerated docs files in one change.
8. **Push and open a PR.**
9. **Poll the PR's real CI checks until they all pass — local validation is NOT the finish line.** After every push, run `gh pr checks <pr-url>` and keep re-polling (short sleep while any check is `pending`) until all checks finish. If a check fails, fetch its actual log (don't guess), find the true root cause, fix it, push again (never `--no-verify`, never force-push), and re-poll. Repeat until every check is green. **The CI environment's toolchain can differ from your local one**, so a clean local run does not guarantee CI passes. Only stop iterating when every check passes, or you hit a genuine product/infra decision that needs a human.

### 4. Common failure modes and fixes

| Symptom | Likely cause | Fix |
|---|---|---|
| `DocGenerator` fails to clone or scrape rule descriptions | `detektVersion` was bumped but no matching `v<version>` tag exists yet in `detekt/detekt`, or the rule-set folder layout changed | Verify the tag exists upstream first; if the folder layout under `detekt-rules-*/src/main` changed, `DocGenerator`'s `isDetektRuleFolder`/scraping logic may need updating (out of scope for a pure version bump — flag it). |
| Docker build fails to start after bumping the runtime base image | Base image bump changed the JDK, breaking compatibility with the compiled artifacts | Check `Dockerfile`'s builder image and runtime image are still JDK-compatible with each other (history shows both were bumped together for exactly this reason). |
| `codacy-plugins-test` fails on a previously-passing fixture | A Detekt rule's default enablement, message text, or behavior changed between versions | Compare against `defaultPatterns` in `DocGenerator.scala` and update fixtures under `docs/tests/`/`docs/multiple-tests/` to match the new expected output. |

### 5. Definition of done

- `detektVersion` (and `detektCommit`, `kotlinVersion` if applicable) bumped consistently in `build.sbt`.
- Generated docs (`docs/patterns.json`, `docs/description/*`) regenerated via `DocGenerator` and committed, with fixture inconsistencies in `docs/tests/`/`docs/multiple-tests/` resolved.
- `sbt compile` and `sbt scalafmt` pass.
- Docker image builds successfully (`sbt stage && docker build`).
- `codacy-plugins-test` commands all pass locally against the freshly built image.
- **After pushing and opening/updating the PR, every CI check on it is green.** Poll `gh pr checks <pr-url>` and iterate on any failure until all pass — a passing local build is not sufficient, because the CI toolchain can differ from your local one.

## What is Codacy

[Codacy](https://www.codacy.com/) is an Automated Code Review Tool that monitors your technical debt, helps you improve your code quality, teaches best practices to your developers, and helps you save time in Code Reviews.

### Among Codacy’s features

- Identify new Static Analysis issues
- Commit and Pull Request Analysis with GitHub, BitBucket/Stash, GitLab (and also direct git repositories)
- Auto-comments on Commits and Pull Requests
- Integrations with Slack, HipChat, Jira, YouTrack
- Track issues in Code Style, Security, Error Proneness, Performance, Unused Code and other categories

Codacy also helps keep track of Code Coverage, Code Duplication, and Code Complexity.

Codacy supports PHP, Python, Ruby, Java, JavaScript, and Scala, among others.

### Free for Open Source

Codacy is free for Open Source projects.
