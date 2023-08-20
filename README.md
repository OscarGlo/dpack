# `dpack`

Variables are stored in armor stands called "stores",
with one armor stand per function call.

## Internal variables

### Scoreboards

| Name  | Description                     |
|:-----:|---------------------------------|
| `-Pn` | nth function argument           |
| `-N`  | Store scope depth (0 = current) |
| `-S`  | Function call success value     |
| `-T`  | Temporary operation value       |

### Tags

`name` stands for the datapack name

|   Name   | Description                          |
|:--------:|--------------------------------------|
| `name-S` | Store                                |
| `name-C` | Current store                        |
| `name-F` | Function call parameters store       |
|  `-In`   | Run depth n `if` branch              |
|  `-An`   | Any previous nth `if` branch has run |


## TODO

- booleans as tags?
- tail recursive functions
- execute single command ifs directly
- improve debug (whitespace, blocks)