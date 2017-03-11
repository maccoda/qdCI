# qdCI
[![BuildStatus](https://travis-ci.org/maccoda/qdCI.svg?branch=master)](https://travis-ci.org/maccoda/qdCI)
[![GitHub tag](https://img.shields.io/github/tag/maccoda/qdCI.svg?maxAge=2592000)]()

A quick and dirty CI tool.

Then check the irony that this has got a builder badge from
a different CI!

## YAML Build File
### File Name
qdCI will look for `.qdci-builder.yml`

### Sections
#### Before Build
This is where will set up all packages and download all
dependencies.

#### Build
This is where we need you to tell us how to builder the
project.

#### After Build
This is where any of the after builder sections need to be.
Whether you want to tell the world it works or send 
someone an email to fix the sh*t they broke.


Goals:
- [ ] Parse how to builder from YAML file (how original)
- [ ] Sync up to git repository for builder
- [ ] Be able to create new builder when new branch is made
- [ ] Do some stuff with pull requests to test the merge
- [ ] Be able to create new workspaces for each builder
