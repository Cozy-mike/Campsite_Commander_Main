# Campsite Commander 🏕️
### IMAD5112 Practicum - Android App in Kotlin

---

## Project Structure

```
app/src/main/
├── java/com/example/campsitecommander/
│   ├── SplashActivity.kt       ← Splash screen (3s timer → Main)
│   ├── MainActivity.kt         ← Main hub (totals + navigation)
│   ├── AddGearActivity.kt      ← Add new gear form (with validation)
│   ├── DetailedViewActivity.kt ← Full gear list view
│   └── GearData.kt             ← Parallel arrays + data functions
│
├── res/layout/
│   ├── activity_splash.xml
│   ├── activity_main.xml
│   ├── activity_add_gear.xml
│   └── activity_detailed_view.xml
│
└── res/values/
    ├── colors.xml              ← Nature/dark mode palette
    ├── strings.xml
    └── themes.xml
```

## How to Set Up in Android Studio

1. Open Android Studio → **New Project** → **Empty Views Activity**
2. Name: `CampsiteCommander`
3. Package: `com.example.campsitecommander`
4. Language: **Kotlin**
5. Min SDK: **API 24**

Then **replace** these files with the provided ones:
- Replace all `.kt` files in `app/src/main/java/com/example/campsitecommander/`
- Replace all `activity_*.xml` in `res/layout/`
- Replace `colors.xml`, `strings.xml`, `themes.xml` in `res/values/`
- Replace `AndroidManifest.xml`

## Key Features Implemented

| Rubric Requirement | Implementation |
|---|---|
| Splash Screen (3s) | `SplashActivity.kt` — Handler with 3000ms delay |
| Parallel Arrays | `GearData.kt` — 4 parallel MutableLists |
| Loop for total | `getTotalItemsPacked()` — for loop over quantities |
| Add Gear | `AddGearActivity.kt` — form with validation |
| View Arrays | `DetailedViewActivity.kt` — loops arrays to build cards |
| Navigation | Intent-based, "Back to Base" via `finish()` |
| Dark/Nature UI | `colors.xml` — forest dark + golden yellow theme |
| Error Handling | Input validation with `.error` messages in AddGearActivity |
