# SBT in Depth

## Doubts to ask

- Is there any command/config to 'automatically' download the dependencies specified at `build.sbt` (Load sbt changes)

## Highlights

### Commands
- `sbt compile` -> compiles the project
- `sbt run` -> runs the project
- `sbt service/run` -> runs the `service` subproject
- `sbt clean service/run` -> cleans and compiles `service` subproject
- `sbt test` -> runs all the tests
- `sbt testOnly ...` -> runs the specified test, separated with spaces and accepts wildcards.
- `sbt evicted` -> suggests/shows improvements in the dependencies to be used
- `sbt projects` -> lists the existing projects within the folder
- `sbt project <name>` -> selects `name` as the active project
- `sbt reload` -> reload the sbt console when you perform changes in the files at runtime
- `sbt settings` -> lists the most commonly used settings
- `sbt tasks` -> lists the tasks available for the current project
- `sbt clean;test;run` -> we can run multiple tasks using one command, separated `;`
- `sbt ~test` -> will rerun all tests when any code changes
- `sbt ~compile` -> will compile code whenever you change a file in `src/main`

### build.sbt
- `ThisBuild` allows us to define a default for all the projects within the sbt file