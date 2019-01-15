# Esercitazione Bonus
--------------
Lista utenti:

```
admin
123456

user
querty
```

Url icona:
https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html#foreground.type=text&foreground.text.text=EsBonus&foreground.text.font=Aclonica&foreground.space.trim=1&foreground.space.pad=0.5&foreColor=rgb(0%2C%2080%2C%20116)&backColor=rgb(58%2C%20219%2C%20238)&crop=0&backgroundShape=square&effects=none&name=ic_launcher

--------------
##### Scadenza: 15/01/19

Per l’esercitazione bonus (facoltativa) dovrete implementare un’applicazione Android composto da un form di login semplificato, che permetta a un utente di loggarsi inserendo username e password. 

L’applicazione deve contenere due activity:

1. Nella prima ci saranno i campi per l’inserimento dei dati richiesti, ovvero username e password (quest’ultimo campo oscurato come visto in FPW); un pulsante (“ACCEDI”) che consente l’accesso; e una text-view che rimandi al form per la registrazione di un nuovo utente (badate bene, questa funzionalità non è da implementare, basta solo il link). 

1. Tramite il pulsante ACCEDI verrà visualizzata la seconda activity; questa conterrà una text-view con testo “Benvenuto username”, dove username corrisponde al nome dell’utente che ha appena fatto l’accesso correttamente, oppure “Accesso negato” se i dati non sono corretti. In aggiunta, un pulsante (“INDIETRO”) per tornare all’activity precedente. 


Controllo dei dati: la vostra applicazione deve attuare due tipi di controlli. In primo luogo, il passaggio alla successiva activity non può avvenire se uno dei campi, o entrambi, non sono stati compilati dall’utente. In tal caso dovete visualizzare dei messaggi di errore come visto a lezione.

Mentre, il secondo controllo richiede che i campi inseriti dall’utente corrente corrispondano a un utente presente in una lista di utenti registrati, definita da voi e di cui quindi disponete username e password.


Links:
1. http://moodle.unica.it/course/view.php?id=50
1. https://docs.google.com/document/d/1Jsmicpid2Y52iOKSpCjxbw-lcpphbHDEIIbtE1BBRb0/edit#heading=h.ukispj1l3ib1
