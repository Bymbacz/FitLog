# FitLog — Aplikacja do monitorowania sylwetki, diety i treningów (Android)

## Temat i opis merytoryczny
Aplikacja mobilna na system Android wspierająca codzienne monitorowanie treningów, diety, nawyków oraz postępów sylwetkowych z możliwością błyskawicznego eksportu wszystkich zebranych danych do formatu **Markdown** (np. do własnych notatek, archiwizacji lub przesłania podsumowania do dietetyka/trenera).

Główne założenia użytkowe:
- **Rejestracja i import aktywności:** zapisywanie treningów siłowych (ćwiczenia, serie, powtórzenia, ciężar) oraz pływackich/cardio (dystans, czas, tempo, kalorie), a także możliwość importu sesji treningowych i dziennej aktywności z zegarka sportowego (Suunto).
- **Moduł żywieniowy:** zapis posiłków w blokach (Śniadanie, Obiad, Kolacja, Przekąski) z automatycznym znacznikiem godziny (z opcją ręcznej edycji) oraz lokalną bazą własnych posiłków.
- **Interaktywne statystyki i wykresy progresu:** dynamiczne wykresy masy ciała, obwodów, częstotliwości treningów, spalonych kalorii i postępu wyników z możliwością filtrowania po rodzaju aktywności (np. tylko basen, tylko siłownia) oraz płynnego przełączania widoków.
- **Nawyki i dokumentacja wizualna (Timelapse):** śledzenie nawodnienia i suplementacji, bezpieczne przechowywanie zdjęć sylwetki w prywatnym magazynie aplikacji, porównanie „Przed / Po” oraz podsumowanie postępów w formie timelapse.
- **Eksport Markdown (1 kliknięcie):** generowanie kompletnego raportu (dieta, treningi, pomiary, statystyki) z wybranego zakresu dat do schowka lub pliku `.md`.

---

## Stos technologiczny i architektura

| Warstwa | Technologia |
|---|---|
| **Język i UI** | Kotlin, Jetpack Compose, Material 3 (Dark Mode First) |
| **Architektura** | MVVM + Repository Pattern, Kotlin Coroutines & Flow |
| **Lokalna baza danych** | Room (SQLite) — pełne działanie offline |
| **Wykresy i analityka** | Vico (natywna biblioteka wykresów dla Compose z animacjami i filtrowaniem) |
| **Aparat i media** | CameraX + prywatny katalog aplikacji (`filesDir`) |
| **Integracje (zegarek / waga)** | Android Health Connect (import treningów i kroków z Suunto App oraz pomiarów z wagi VitaFit) |
| **Powiadomienia** | WorkManager (cykliczne raporty i przypomnienia) |

---

## Zakres projektu: MUST HAVE vs NICE TO HAVE

| Priorytet | Funkcjonalność | Status |
|---|---|---|
| **MUST** | Nowoczesny interfejs w trybie ciemnym (Dark Mode) z 4 głównymi ekranami (Dziś, Trening, Dieta, Progres) | W trakcie |
| **MUST** | Lokalna baza danych Room (SQLite) dla treningów, posiłków, pomiarów, nawyków i metadanych zdjęć | Do zrobienia |
| **MUST** | Rejestr treningów siłowych (serie, powtórzenia, ciężar, objętość) oraz basenu/cardio (dystans, czas, kalorie) | Do zrobienia |
| **MUST** | Moduł diety: bloki posiłków z automatyczną godziną (edytowalną) + własna baza zapisanych posiłków | Do zrobienia |
| **MUST** | Licznik wypitej wody oraz dzienna checklista suplementów | Do zrobienia |
| **MUST** | Pomiary wagi i obwodów ciała + dynamiczne wykresy progresu (częstotliwość treningów, kalorie, waga, obwody) z filtrowaniem po typie treningu (np. tylko basen) i płynnym przełączaniem | Do zrobienia |
| **MUST** | Zdjęcia sylwetki w prywatnym katalogu aplikacji + widok porównania „Przed / Po” i podgląd timelapse | Do zrobienia |
| **MUST** | Kompletny eksport do Markdown (dzień / tydzień / miesiąc, wszystkie dane i podsumowania) — kopiowanie 1 kliknięciem do schowka i zapis `.md` | Do zrobienia |
| **NICE** | Integracja z **Health Connect** — automatyczny import sesji treningowych i kroków z zegarka sportowego (Suunto) oraz wagi (VitaFit) | Planowane |
| **NICE** | Powiadomienia cykliczne (WorkManager): przypomnienie o raporcie tygodniowym/miesięcznym i nawykach | Planowane |
| **NICE** | Eksport podsumowania timelapse (miesiąc / rok) do pliku wideo MP4 lub GIF | Planowane |
| **NICE** | Wyszukiwanie produktów w zewnętrznej bazie (Open Food Facts API) + skaner kodów kreskowych | Planowane |
| **NICE** | Zaawansowana analityka siłowa (szacowane 1RM, rekordy życiowe PR) | Planowane |
| **NICE** | Kopia zapasowa i przywracanie lokalnej bazy danych (JSON / `.db`) | Planowane |

---

## Dziennik aktualizacji (Cotygodniowe raporty — Środy)

### Tydzień 1 (Środa — Konfiguracja projektu)
- Utworzono repozytorium GitHub, doprecyzowano temat, architekturę i tabelę MUST / NICE.
- Skonfigurowano projekt Android (Kotlin, Jetpack Compose, Material 3, minSdk 26).
- Wdrożono bazowy motyw Dark Mode oraz szkielet dolnej nawigacji (Dziś, Trening, Dieta, Progres).

### Tydzień 2 (Plan)
- Implementacja schematu bazy danych Room (encje + DAO).
- Moduł diety (bloki posiłków z godziną + baza własnych posiłków) oraz szybkie akcje na ekranie głównym (woda, suplementy).

---

## Uruchomienie projektu
1. Sklonuj repozytorium i otwórz w **Android Studio** (wersja wspierająca Kotlin DSL / Compose).
2. Zsynchronizuj zależności Gradle (`Sync Project with Gradle Files`).
3. Uruchom konfigurację `app` na emulatorze lub fizycznym urządzeniu z systemem **Android 8.0 (API 26)** lub nowszym.