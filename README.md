# poc-scala-kata-ci
Kata generator for any languages with Scala with its CI pipeline.

# Table of Contents
1. [Project](#project)
2. [Project CI](#project-ci)

## Project
| Require | Version |
| ----------- | ----------- |
| Scala | 2.12 |
| ScalaTest | 2.0.0 |
| Maven | 3.4.6 |


## Project CI
### Pipeline installation
| Require | Version |
| ----------- | ----------- |
| docker | 19.03.12 |
| docker-compose | 1.26 |


Use the `docker-compose` command to automatically generate the project CI pipeline tools in Docker containers.

| Tool | Docker Image | Usage |
| ----------- | ----------- | ----------- |
| Jenkins | based on jenkins/jenkins, with our custom pre-installed plugins | Continuous Integration server
| SonarQube | sonarqube:8.4.1-community | Code Quality scan
| Nexus | sonatype/nexus:oss | Artifact deployment

To run the install : 
```
$> cd docker
$> chmod +x prerequisites.sh && ./prerequisites.sh && docker-compose up
```

Once the installations are completed, one should be able to access to the following UIs:

| Tool | URL | User / Password
| ----------- | ----------- | ----------- |
| Jenkins | http://localhost:8081/ | admin / admin
| SonarQube | http://localhost:9002/ | admin / admin
| Nexus | http://localhost:8083/nexus/ | admin / admin123


To run the stack again in detached mode :
```
$> cd docker
$> docker-compose -d
```

### Pipeline configuration
Next, configure it to link the tools together. As a reminder, below are the main steps :

#### Jenkins
- Copy paste the repo git URL and add new multi-branch pipeline project with it.
- Administration > Configuration files > Configure the [Config File Provider plugin](https://plugins.jenkins.io/config-file-provider/) used as Jenkins internal *settings.xml*.
- Configure Nexus and SonarQube. Specify your IP address instead of localhost (eg: 192.168.1.32) or you may encounter some issues.

#### SonarQube 
- Generate a token for Jenkins and copy paste it into Jenkins SonarQube configuration.

#### Jenkinsfile
Replace the file UUID with the previously created file UUID.
```
pipeline {
    environment {
        // Config File Provider plugin: Replace that with your created file UUID
        $FILE_ID_UUID = "8310d80b-cf52-422d-9041-c61556b21e28"
    }`
    ...
```

#### Nexus
Finally, one should be able to see the generated artifacts in *Repositories > Snapshots > fr.codeworks.katagenerator.*