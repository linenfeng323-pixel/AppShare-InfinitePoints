#!/bin/sh
GRADLE_HOME="${HOME}/.gradle/wrapper/dists/gradle-8.2-bin"
GRADLE_BIN="$GRADLE_HOME/gradle-8.2/bin/gradle"
if [ ! -f "$GRADLE_BIN" ]; then
    echo "Gradle not found, downloading..."
    mkdir -p "$GRADLE_HOME"
    cd "$GRADLE_HOME"
    wget -q https://services.gradle.org/distributions/gradle-8.2-bin.zip
    unzip -q gradle-8.2-bin.zip
    rm gradle-8.2-bin.zip
fi
exec "$GRADLE_BIN" "$@"
