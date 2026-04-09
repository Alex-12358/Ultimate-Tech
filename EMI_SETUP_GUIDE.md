# ⚙️ EMI Интеграция - Пошаговая инструкция

## 🎯 Цель
Полная интеграция кода EMI в ваш проект Ultimate Tech для возможности кастомизации и модификации.

## 📋 Этапы интеграции

### Этап 1: Проверка структуры ✅

Убедитесь, что следующие папки существуют:

```
src/main/java/dev/emi/
├── emi/          ✅ (315 Java файлов)
└── forge_emi/    ✅ (Forge специфичный код)

src/main/resources/emi_temp/
├── emi-forge.mixins.json
├── pack.mcmeta
└── META-INF/mods.toml
```

**Статус:** ✅ Скопировано

---

### Этап 2: Обновление build.gradle

#### ⚠️ Важно: Проверьте зависимости

Откройте `build.gradle` и убедитесь, что есть следующие зависимости:

```gradle
dependencies {
    // Forge
    minecraft 'net.minecraftforge:forge:1.20.1-47.4.10'
    
    // EMI может требовать
    // modApi 'dev.emi:emi:1.1.22+1.20.1'
    // ИЛИ если используем встроенный код
    
    // Architectury (проверьте версию в оригинальном EMI build.gradle)
    // modImplementation 'dev.architectury:architectury-forge:...'
    
    // Cloth Config (часто требуется)
    // modImplementation 'me.shedaniel.cloth:cloth-config-forge:...'
}
```

**Что делать:**
1. Откройте оригинальный `build.gradle` EMI: https://github.com/emilyploszaj/emi/blob/1.20/build.gradle
2. Скопируйте нужные зависимости
3. Добавьте их в ваш `build.gradle`

---

### Этап 3: Обновление mods.toml

Откройте `src/main/resources/META-INF/mods.toml` и добавьте entry points для EMI:

```toml
# Существующие строки...

# EMI Entry Points
[[entrypoints."fmlmod"]]
value = "dev.emi.emi.platform.forge.EmiForge"

# Если нужна клиентская часть (обычно нужна)
[[entrypoints."fmlmod"]]
value = "dev.emi.emi.platform.forge.EmiClientForge"
```

**Проверка:** Найдите строку `modLoader = "javafml"` - entry points должны быть после неё.

---

### Этап 4: Объединение Mixins

#### ⚠️ Важно: Интеграция mixins конфигурации

1. **Откройте ваш файл mixins:**
   - `src/main/resources/ultimate_tech.mixins.json`

2. **Откройте EMI mixins:**
   - `src/main/resources/emi_temp/emi-forge.mixins.json`

3. **Объедините конфигурации:**

Ваш файл должен выглядеть примерно так:

```json
{
  "required": true,
  "minVersion": "0.8.5",
  "package": "org.mod.ultimate_tech.mixin",
  "compatLevel": "JAVA_17",
  "refmap": "ultimate_tech.refmap.json",
  "mixins": [
    // Ваши mixins...
  ],
  "client": [
    // Ваши client mixins...
    // + Добавьте EMI mixins отсюда: emi-forge.mixins.json
  ]
}
```

**Или используйте отдельный файл:**

```json
{
  "required": true,
  "minVersion": "0.8.5",
  "package": "dev.emi.emi.mixin",
  "compatLevel": "JAVA_17",
  "mixins": [ /* ... */ ],
  "client": [ /* ... */ ]
}
```

И добавьте в `mods.toml`:

```toml
[[mixin]]
config = "emi-forge.mixins.json"
```

---

### Этап 5: Компиляция и тестирование

#### 1. Чистая сборка:

```bash
./gradlew clean build
```

**Что должно произойти:**
- ✅ Проект успешно компилируется
- ✅ Нет ошибок импортов
- ✅ Нет ошибок mixins
- ✅ JAR файл создан

#### 2. Запуск dev среды:

```bash
./gradlew runClient
```

**Что проверить:**
- ✅ Игра запускается без ошибок
- ✅ В логе нет критических ошибок EMI
- ✅ Экран EMI открывается (горячая клавиша: O по умолчанию)

#### 3. Проверка функциональности:

- [ ] Откройте инвентарь
- [ ] Нажмите горячую клавишу EMI (O)
- [ ] Должен открыться экран с рецептами
- [ ] Поиск работает
- [ ] Можно кликать на рецепты

---

### Этап 6: Кастомизация

#### Добавьте свои рецепты

Отредактируйте файл:
```
src/main/java/org/mod/ultimate_tech/integration/emi/UltimateTechEmiPlugin.java
```

Пример регистрации кастомного рецепта:

```java
public static void onRegistryInit(EmiRegistry registry) {
    // Регистрируйте ваши рецепты Ultimate Tech
    registry.addRecipe(new MyCustomRecipe());
    
    // Или используйте встроенные рецепты
    for (Recipe recipe : recipes) {
        registry.addRecipe(new VanillaEmiRecipe(recipe));
    }
}
```

---

## 🐛 Возможные проблемы и решения

### Проблема 1: "Cannot resolve symbol 'dev.emi.emi'"

**Решение:**
1. Выполните `./gradlew clean build`
2. Синхронизируйте Gradle: IDE → Gradle → Refresh
3. Перезагрузите IDE

### Проблема 2: Ошибка mixins

**Решение:**
1. Проверьте что `emi-forge.mixins.json` правильно указан
2. Убедитесь что пакет `dev.emi.emi.mixin` существует
3. Проверьте синтаксис JSON

### Проблема 3: EMI экран не открывается

**Решение:**
1. Проверьте entry points в `mods.toml`
2. Проверьте логи на ошибки инициализации
3. Попробуйте другую горячую клавишу

### Проблема 4: Конфликт пакетов

**Решение:**
Если у вас есть свои классы в `dev.emi`:
```bash
# Переименуйте скопированные файлы
mv src/main/java/dev/emi/emi → src/main/java/dev/emi/emi_ultimate_tech
# И обновите импорты везде
```

---

## 📊 Чек-лист завершения

### Подготовка
- [ ] EMI код скопирован (315 файлов, 28k+ строк)
- [ ] Структура папок верна

### Конфигурация
- [ ] Обновлены зависимости в build.gradle
- [ ] Добавлены entry points в mods.toml
- [ ] Объединены mixins конфигурации
- [ ] Удалена/переименована папка emi_temp

### Компиляция
- [ ] `./gradlew clean build` выполнена успешно
- [ ] Нет ошибок компиляции
- [ ] JAR файл создан

### Тестирование
- [ ] Игра запускается (`./gradlew runClient`)
- [ ] EMI экран открывается
- [ ] Рецепты отображаются
- [ ] Поиск работает

### Кастомизация
- [ ] Созданы кастомные рецепты
- [ ] Работает интеграция с Ultimate Tech
- [ ] Все функции работают как ожидается

---

## 🔗 Полезные ссылки

- **EMI Repository:** https://github.com/emilyploszaj/emi
- **EMI Wiki:** https://github.com/emilyploszaj/emi/wiki
- **Forge Documentation:** https://docs.minecraftforge.net
- **Gradle Docs:** https://gradle.org/releases/

---

## 💡 Советы

1. **Начните с малого** - сначала просто интегрируйте, потом кастомизируйте
2. **Читайте логи** - если что-то не работает, проверьте логи (logs/ папка)
3. **Смотрите исходный код** - комментарии в EMI файлах очень полезны
4. **Используйте IDE** - IntelliJ IDEA поможет найти ошибки быстрее

---

**Дата создания:** 2026-04-09  
**Версия EMI:** 1.20  
**Версия Forge:** 47.4.10+

Удачи с интеграцией! 🚀

