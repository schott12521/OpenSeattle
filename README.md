Open Seattle Engineering Question

### Prompt
Imagine you're tasked with creating a practical solution for a local shelter to manage their donation inventory. This shelter is in need of a user-friendly tool to accurately record and track the inflow and outflow of donations, and to generate insightful reports about their donation management.

### Running the program

The program can be run via [gradle](https://gradle.org/):

```shell
./gradlew run --console=plain
```

Which will start the application and prompt the user with:

```
Welcome to the Shelter Donation System!
Available commands: registerDonation, registerDistribution, generateInventoryReport, generateDonatorReport, exit.
```

Now, the user may enter any of the above commands and begin interacting with the program-- entering `exit` when they are complete.

### Testing

Tests are in `src/test` and can be run via IDE (IntelliJ).

### Troubleshooting

- Ensure that the gradle wrapper (`./gradlew`) has sufficient permissions to run:

```shell
chmod +x gradlew
```