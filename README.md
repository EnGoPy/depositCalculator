# depositCalculator

Aplikacja restowa pozwalająca na przechowywanie poszczególnych lokat, zwracanie listy lokat, obliczenie stopnia oszczędności
konkretnej lokaty dla bieżącej daty lub całego okresu trwania umowy, a także zwracanie historii obliczeń dla poszczególnej lokaty.<br>
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



Aplikacja posiada 4 endpointy:

<h4>*GET</h4> <h5>"api/investments"</h5>
<br> Zwraca listę dostępnych lokat w formacje Json. Lokata w formie:<br>
"id" :<br>
"name" :
