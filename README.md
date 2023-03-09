# TaskList

## Dilan Kirak 
App Entwicklung mit Android - Projekt: TaskList

Ziel meines Projektes ist eine App, in der man seine Tasks speichern kann. Diese App hat einen Login-Bereich mit einer Datenbankimplentierung.
Kommen wir zum Ablauf der App:
Zunächst registriert man sich in der App, wenn man noch keinen Account hat. Daraufhin wird der Nutzer zur Homepage weitergeleitet, in der er seine Task eintragen kann. Die Task werden mit einer Checkbox versehen. Sobald der Nutzer seine Aufgabe erledigt hat, kann er diese löschen, in dem er die Aufgabe abhackt. 
Die Tasks können priorisieren werden, indem man sie jeweils nach oben oder unten verschiebt. 

## Klassen und Navigation:



https://user-images.githubusercontent.com/119820557/224100084-fd64480f-27b3-4967-b373-52f206f34466.mp4



DBHelper - Datenbankverwaltung
MainActivity - Login-Bereich/Anmeldung( Ermöglicht dem Nutzer dier Anmeldung mit einem auf der Datenbank hinterlegten Benutzerkontos)
Registration - Registierung (Ermöglicht das Erstellen eines Benutzerkontos)
ToDoListe - Start (Tasklist, wird hier erstellt)
Settings - Ermöglicht die Verwaltung der Benachrichtigung und Impressum 
Impressum - InfoText über den Ersteller
Message - Ermöglicht auch die Benachrichtigung an- und ausschalten 
Task - Variablen für die Tasklist
TaskListAdapter - Ermöglicht das Löschen der Task, durch klicken der Checkbox
TaskListTouchCallback - Ermöglicht den Nutzer die Tasks zu verschieben
TaskManager - Enthält Methoden für die Taskliste
TaskViewHolder - Enthält die Methode für die Checkbox




