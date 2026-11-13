# Auralis Music

Auralis Music é um player de música Android nativo, construído com Kotlin, Jetpack Compose, Media3/ExoPlayer e DataStore.

## Funcionalidades principais

- Biblioteca musical local com leitura via MediaStore
- Reprodução local com ExoPlayer e player em segundo plano
- Mini-player e tela de reprodução
- Playlists persistidas em Room
- Personalização visual com tema escuro/claro e cor de destaque
- Busca local por nome de música
- Workflow GitHub Actions para geração de APK debug

## Stack

- Kotlin
- Jetpack Compose
- Material 3
- AndroidX Media3
- Room
- DataStore
- Gradle Kotlin DSL

## Compilar localmente

1. Instale o Android SDK com o comando `sdkmanager`.
2. Defina `local.properties` com o caminho do SDK:
   ```properties
   sdk.dir=/opt/android-sdk
   ```
3. Execute:
   ```bash
   export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
   ./gradlew assembleDebug
   ```
4. O APK será gerado em `app/build/outputs/apk/debug/app-debug.apk`.

## Testes

```bash
./gradlew testDebugUnitTest
```

## Observações

- A leitura de músicas locais exige a permissão de áudio.
- A funcionalidade de reprodução em segundo plano usa `MediaSessionService`.
- Este projeto foi estruturado como um MVP funcional e extensível para continuação.
