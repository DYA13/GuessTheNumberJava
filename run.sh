#!/bin/bash

# Очистить старые скомпилированные классы
echo "🧹 Cleaning previous build..."
rm -rf out
mkdir out

# Компиляция всех Java файлов в папке src/
echo "⚙️ Compiling source files..."
if javac -d out $(find src -name "*.java"); then
    echo "✅ Compilation successful"
else
    echo "❌ Compilation failed"
    exit 1
fi

# Запуск главного класса
echo "🚀 Running the game..."
java -cp out Main
