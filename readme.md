1. 
Zaimportuj projekt jako projekt Maven, wg poniższych wskazówek:
W IntelliJ wybieramy: File –> New –> Project from Existing Sources... Wskazujemy lokalizację katalogu ze sklonowanym
projektem i zatwierdzamy. Następnie w nowym oknie wybieramy: Import project from external model i wskazujemy Maven
Wybieramy kolejno opcje: Next –> Next –> Next –> Finish
2.
W pliku src/main/resources/application.properties w lini 4 (spring.datasource.url=jdbc:mysql://localhost:3306/ZadRekrutacyjne)
zmien nazwe bazy danych na taką jaką masz ty (z "ZadRekrutacyjne" na "twojadb").
W lini 5 podaj login do towjej bazy
W lini 6 podaj haslo
3.
Uruchom aplikacje i przejdz do przegladarki na adres http://localhost:8080/
4.
Zarajestruj dwa konta uzywajać linka "Zarejestruj sie".
5.
przejdz do bazy danych do tabeli user_roles i zmien jednemu uzytkownikowi role z "USER" na "ADMIN".
6. 
Zaloguj sie do aplikacji uzywajac danych uzytkownika z rola "ADMIN".
7.
Aby przetestowac dzialanie aplikacji dodaj pare samochodow(naprzyklad poprzez uzycie linka "dodaj auto").
8.
Po sprawdzeniu funkcji admina wyloguj sie(http://localhost:8080/logout) i zaloguj na konto stworzonego
przez siebie "USER"'a.
9.
Sprawdz działanie pozostałych funkcji.