# Apache Hadoop mapreduce demo example
This is a starter repo for Apache Hadoop docker.

## Build
```
git clone https://github.com/GezimSejdiu/hadoop-starter
cd hadoop-starter
mvn clean package
```

## Running the application on a Hadoop cluster via Docker

To run the application, execute the following steps:

1. Setup a Hadoop cluster as described on http://github.com/big-data-europe/docker-hadoop.
2. Build the Docker image:
`docker build --rm=true -t bde/mapreduce-app .`
3. Run the Docker container:
`docker run --name my-mapreduce-app --network hadoop --env-file ./config/hadoop/hadoop.env -d bde/mapreduce-app`
