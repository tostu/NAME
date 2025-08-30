# name-generator

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/name-generator-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- LangChain4j OpenAI ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): Provides the basic integration with LangChain4j
- LangChain4j Easy RAG ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): Provides the Easy RAG functionality with LangChain4j

## Provided Code

### LangChain4j Easy RAG

This code is a very basic sample service to start developing with Quarkus LangChain4j using Easy RAG.

This code is set up to use OpenAI as the LLM, thus you need to set the `QUARKUS_LANGCHAIN4J_OPENAI_API_KEY` environment variable to your OpenAI API key.

In `./easy-rag-catalog/` you can find a set of example documents that will be used to create the RAG index which the bot (`src/main/java/org/acme/Bot.java`) will ingest.

On first run, the bot will create the RAG index and store it in `easy-rag-catalog.json` file and reuse it on subsequent runs.
This can be disabled by setting the `quarkus.langchain4j.easy-rag.reuse-embeddings.enabled` property to `false`.

Add it to a Rest endpoint:
```java
    @Inject
    Bot bot;
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String chat(String q) {
        return bot.chat(q);
    }
```

In a more complete example, you would have a web interface and use websockets that would provide more interactive experience, see [ChatBot Easy RAG Sample](https://github.com/quarkiverse/quarkus-langchain4j/tree/main/samples/chatbot-easy-rag) for such an example.

---

## Hexagonal Name Generator API (Gemini)

This module exposes a hexagonal-architecture microservice to generate names using Google Gemini. It uses Lombok for models and MapStruct for mapping between REST DTOs and domain objects.

- Domain: `me.tostu.names.domain.*`
- Application: `me.tostu.names.application.GenerateNameService`
- Inbound adapter (REST): `me.tostu.names.infrastructure.adapter.in.rest.*`
- Outbound adapter (Gemini): `me.tostu.names.infrastructure.adapter.out.gemini.*`

### Endpoint
POST /api/v1/names

Request body:
{
  "template": "BRAND_FRIENDLY", // optional, defaults to BRAND_FRIENDLY
  "context": "solar analytics for homes", // your brief/product/keywords
  "count": 10 // optional, defaults to 10
}

Response body:
{
  "names": ["SunSense", "HelioHome", "SolarScope", ...]
}

### Templates
- BRAND_FRIENDLY
- TECHY
- FANTASY
- SHORT_AND_CATCHY
- PROFESSIONAL

### Configuration
Set your Gemini API key (required for real responses):
- Environment variable: `export GEMINI_API_KEY=your_key`
- Or JVM property: `-Dgemini.api.key=your_key`

Other properties (see src/main/resources/application.properties):
- `quarkus.rest-client.gemini.url=https://generativelanguage.googleapis.com`
- `gemini.model=gemini-1.5-flash` (you may change to another Gemini model)

When no API key is set, the service will return an empty list and log a warning.

### Run locally
- Dev: `./mvnw quarkus:dev`
- Package: `./mvnw package`

Example cURL:

curl -s -X POST http://localhost:8080/api/v1/names \
  -H 'Content-Type: application/json' \
  -d '{
        "template":"SHORT_AND_CATCHY",
        "context":"AI fintech app for freelancers",
        "count":8
      }'
