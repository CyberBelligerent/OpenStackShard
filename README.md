# OpenStackShard
## About
Provider implementation for ARCTIC's Shard layer

OpenStackShard is the official OpenStack provider plugin for ARCTIC (Automated Range Creation Tool and Integrated Console). This plugin allows ARCTIC to provision full cyber environments directly on OpenStack — including networks, volumes, security groups, routers, and compute instances.

## Features
OpenStackShard supports building all core OpenStack resources required for a cyber range:

### Host Creation (Servers)
- Image + Flavor selection
- Volume backed boot supports
- Network attachment
- Instance wait logic

### Network Resources
- Networks
- Subnets
- Routers
- Security Groups
- Security Group Rules

### Volume Resources
- Volume Creation
- Bootable Volume Support
- Volume Wait Logic

## Configuration
Once the plugin is dropped into ARCTIC's ```/providers``` directory, the provider UI will eventually expose the following fields:
- endpoint / required / Keystone v3 auth URL
- username / required / Project-scoped username
- password / required / Account password
- projectId / required / The UUID of the target project
- domain / non-required / Defaults to "Default"

## What This Plugin Provides
OpenStackShard is responsible ONLY for converting ARCTIC's abstract instructions into OpenStack actions. It does not:
- redesign how ARCTIC works
- manage orchestration logic
- enforce workflow Rules

These all belong to Flock, Iceberg, and Orca.

OpenStackShard keeps a single responsbility. Convert ARCTIC to OpenStack

## Status
This provider is actively in development and moving toward ARCTIC's MVP.
Expect improvements as ARCTIC's Shard, UI, and task engine evolve.

## Contributing
Contributions are welcome!
To submit improvements, open a PR or issue!
