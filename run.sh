#!/bin/bash

# Pulizia dei file compilati precedenti
echo "🧹 Pulizia della compilazione precedente..."
rm -rf out
mkdir out

# Compilazione di tutti i file Java nella cartella src/
echo "⚙️ Compilazione dei file sorgente..."
if javac -d out $(find src -name "*.java"); then
    echo "✅ Compilazione completata con successo"
else
    echo "❌ Compilazione fallita"
    exit 1
fi

# Avvio del gioco
echo "🚀 Avvio del gioco..."
java -cp out Main
