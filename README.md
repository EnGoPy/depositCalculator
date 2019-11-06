# depositCalculator

Aplikacja restowa pozwalająca na przechowywanie poszczególnych lokat, zwracanie listy lokat, obliczenie stopnia oszczędności
konkretnej lokaty dla bieżącej daty lub całego okresu trwania umowy, a także zwracanie historii obliczeń dla poszczególnej lokaty.<br>
<h3>UWAGA:</h3>
<p>W repozytorium znajduje się plik: "DepositCalc.postman_collection.json", w którym są wyeksportowane wywołania poszczególnych endpointów.</p>
Baza danych operuje na encjach:<br>
<h4>CalculationEntity</h4>
<h6>- id              Long<br>
- amount          BigDecimal<br>
- calculationDate LocalDate<br>
- deposit         DepositEntity<br>
- algorithmType   String<br>
- profit          BigDecimal<br><br></h6>

<h4>DepositEntity</h4>
<h6>-   id                  Long<br>
    -   name                String<br>
    -   debitRate           double<br>
    -   capitalization      int<br>
    -   startDate           LocalDate<br>
    -   endDate             LocalDate<br>
    -   calculations        List<CalculationEntity><br>
    -   calculationCounter  Integer<br>
    </h6>
    



<h5>Aplikacja posiada 4 endpointy:</h5>

<h3>*GET   "api/investments"</h3>
<h5><br> Zwraca listę dostępnych lokat w formacje Json. Lokata w formie:<br>
    </h5>
    <h6>
"id" :<br>
"name" :
</h6>
<br>
<h3>*POST   "api/investments"</h3>
<h5><br> Zapisuje w bazie danych obiekt lokaty. Obiekt lokaty powinien zawierać pola:<br>
   </h5>
   <h6>
   "name" : <i>nazwa lokaty</i><br>
"debitRate" : <i>oprocentowanie w skali roku</i><br>
"capitalization" : <i>okres kapitalizacji odsetek w miesiącach. Dostępne - 1, 3, 6, 12 mscy.</i><br>
"startDate" : <i>data otwarcia lokaty w formacie "yyyy-MM-dd".</i><br>
"endDate" : <i>data zamknięcia lokaty w formacie "yyyy-MM-dd".</i><br>
</h6>
<br>
<br>
<h3>*POST   "api/investments/{id}/calculations"</h3>
<h5><br> Dodaje do bazy danych wynik kalkulacji oszczędności na podstawie numeru {id} lokaty w adresie url,
    oraz na podstawie dostarczonego modelu kalkulacji. Pierwszym parametrem jest kwota bazowa oszczędności, dla 
    której zostaną wykonane obliczenia. Kalkulacja może zostać przeprowadzna dla obecnego dnia,
    ustawiając wartość <i>current</i> lub dla całego okresu obowiązywania lokaty wybierając <i>whole</i>.
    Model wejścia powinien zawierać formę:<br>
    </h5>
    <h6>
    "amount" : <i>kwota bazowa</i><br>
    "calculationType" : <i>model kalkulacji: "current" lub "whole"</i><br>
    <h6>
    <h4> Zwracany jest obiekt w formacie Json posiadający atrybuty:</h4><br>
    <h6>
    "amount" : <i>kwota bazowa</i><br>
    "calculationDate" : <i>data wykonania kalkulacji</i><br>
    "depositName" : <i>nazwa lokaty</i><br>
    "algorithmType" : <i>algorytm obliczeń ("current", "whole")</i><br>
    "profit" : <i>obliczony zysk</i><br>
    </h6>
        <h4>Wynik poprawnie wykonanej kalkulacji jest zapisywany w bazie danych</h4>
    <br><br>   
    <h3>*GET   "api/investments/{id}/calculations"</h3>
<h5><br> Zwraca obiekt poszczególnej lokaty o numerze {id}, jej atrybuty oraz historię wykonanych transakcji w formie Json:<br><h6>
    "id" : <i>id lokaty</i><br>
    "name" : <i>nazwa lokaty</i><br>
    "debitRate" : <i>oprocentowanie w skali roku</i><br>
    "capitalization" : <i>okres kapitalizacji odsetek w miesiącach.</i><br>
    "startDate" : <i>data otwarcia lokaty w formacie "yyyy-MM-dd".</i><br>
    "endDate" : <i>data zamknięcia lokaty w formacie "yyyy-MM-dd".</i><br>
    "calculations" :  <i>lista kalkulacji w formie</i>
    <br>[ {
    "amount" : <i>kwota dla której wykonano obliczenia</i><br>
    "calculationDate" : <i>data wykonania kalkulacji</i><br>
    "algorithmType" : <i>algorytm obliczeń ("current", "whole")</i><br>
    "profit" : <i>obliczony zysk</i><br>
    } ]
    </h6>

<h4>Do połącenia ze zdalną bazą danych umieszczoną na koncie Heroku potrzebna jest <u>nazwa użytkownika</u> oraz <u>hasło</u>. W projekcie wykorzystano technologie:</h4><br>
<h6>
    -Spring Boot, <br>
    -Spring MVC<br>
    -Spring Data JPA<br>
    -Hibernate<br>
    -Gradle<br>
    -Database (PostgreSQL)<br>
    -Lombok<br>
    -Git<br></h5>
    <h4>Warstwy aplikacji:<br></h4>
<h6>
    -Web (MVC)<br>
    -Service/Business Logic<br>
    -DAO (JPA + Hibernate)<br>
    -Database </h5>
