# Codacy Detekt

This is the docker engine we use at Codacy to have [Detekt](https://github.com/arturbosch/detekt) support.
You can also create a docker to integrate the tool and language of your choice!
Check the **Docs** section for more information.

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ccdc504c39e44ae998bcc9e948c9fae3)](https://www.codacy.com/gh/codacy/codacy-detekt?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=codacy/codacy-detekt&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/codacy/codacy-detekt.svg?style=svg)](https://circleci.com/gh/codacy/codacy-detekt)

## Usage

You can create the docker by doing:

```bash
sbt docker:publishLocal
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
