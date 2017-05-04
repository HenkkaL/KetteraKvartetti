### Ohjelmistotuotanto, kevät 2017, miniprojektin loppuraportti


## Ketterän kvartetin projektiraportti


Miniprojekti lähti erinomaisesti käyntiin. Ensimmäisen asiakastapaamisen jälkeen saatiin vaivatta kasaan suunnitelma ohjelman toteuttamiseksi. Java oli kaikille tuttu, joten se oli luonteva valinta ohjelmointikieleksi. Spring-framework otettiin käyttöön osin siksi, että se esiintyi laskuharjoitustehtävissä, mutta myös siksi, että se oli osalle entuudestaan tuttu web-palvelinohjelmoinnin kurssilta. Herokuun oli myös osalle entuudestaan tuttu. Se oli luonteva valinta tietokantaa käyttävälle nettisovellukselle. Ohjelman build-työkaluna käytettiin gradlea luultavasti siksi, että se esiintyi kurssilla.

Jokainen sprintti onnistui miltei täydellisesti vastaamaan asetettuihin haasteisiin. Vain neljäs eli viimeinen sprintti jäi hieman ”vajaaksi”. Tämä sprintti oli muita lyhyempi, joten se sekoitti ryhmän rytmin. Jokaisella sprintillä oli myös omat leimalliset haasteensa, jotka hallitsivat aina kyseisen sprintin keskustelua.


### Gradle, Selenium ja integraatiohelvetti

Tämän piti olla pikku juttu. Gradle ja Selenium eivät kuitenkaan lähteneet vaivatta toimimaan yhdessä.  Integraatioyritykset rokottivat paljon ensimmäisen sprintin työaikaa, eivätkä johtaneet toivottuun lopputulokseen. Vasta sprintin lopussa, kiitos Matti Luukkaisen konsultaation, syntyi ajatus erillisestä testausohjelmasta. Tämä ohjelma ohjelman sisällä ei valmistunut sprintin loppuun mennessä, mutta sai kuitenkin asian liikkumaan eteenpäin.
 

### Ongelmallinen Selenium

Toinen sprintti oli vaivattomin. Selenium-projekti Cucumber-testeineen eteni jälkijunassa, sillä asian kanssa oli otettu velkaa ensimmäisessä sprintissä. Tämä tarkoitti sitä, että edelleen osa ryhmän voimavaroista oli sidottu toteuttamaan erillistä testiohjelmaa. Ilman tätä velkaa, olisi sprintti ollut vaivattomuudessaan jopa tylsä. 


### Tietokanta pystyyn ja tuotanto Herokuun

Tuotannon vieminen Herokun palvelimelle sisälsi odotetusti omat haasteensa. Tätä osattiin odottaa, ja etukäteen oli valmistauduttu siihen, että kolmannesta sprintistä tulee haastava. Ensinnäkin projektille piti luoda kaksi ympäristöä: tuotantoa ja testausta varten. Lokaalina toimivan version vieminen palvelimelle aiheutti viilailua. Tietokannan pystytys ja käyttöönotto vaati omat konfiguraationsa. Versio, jossa ei ollut ennen Herokua ja tietokantaa mitään vikaa, vaati nyt pientä säätöä sieltä ja täältä. Tämä vei aikaa, mutta ei pysäyttänyt liikettä. Sprintin lopussa Travisin buildi hajosi, vaikka ohjelma toimi.


### Travis ei buildaa!

Neljäs sprintti oli tynkä ja siksi kiireinen. Viikko oli muita lyhyempi alkaen torstain asiakastapaamisesta ja päättyen jo keskiviikkona demoon. Lisäksi viikolle sattui vappu, joka rokotti yhden arkipäivän pois. Toiminta oli suoraviivaista ja jalostunutta aikaisempien viikkojen kokemuksista. Travis saatiin buildaamaan hiomalla hieman sovelluksen testejä. Heroku vaati omansa, sillä sekin vaati ajoittaista tietokannan uudelleenajamista. Demotilaisuuden jälkeen selvisi, että Travis tukee oletusarvoisesti javan versiota seitsemän, käyttämämme kahdeksan sijasta. Lyhyt viikko aiheutti kuitenkin sen, että yksi story jäi kesken. Toisaalta, Travis buildasi, badget loistivat vihreinä ja ohjelma pyöri Herokussa. Tällaista ohjelmaa kelpasi demota. 


## Hyvässä ryhmässä on hyvä henki

Ketterä kvartetti koostuu viidestä sosiaalisesti kyvykkäästä henkilöstä. Jäsenten välillä on eroja siinä, kuinka vaivattomasti syntyy valmista koodia sekä repertuaarista käyttää erilaisia ohjelmointiin liittyviä apuvälineitä ja kirjastoja. Sen sijaan, jokaista jäsentä yhdistää avoin ja kannustava asenne suunnitteluun, teknisten seikkojen ihmettelyyn sekä yleisempään keskusteluun koskien ohjelmistotuotantoa. Ryhmässä sai esittää ja esitettiinkin paljon kysymyksiä. Kokeneemmat opastivat kokemattomampia. Jokainen jäsen sai kokea olevansa samalla viivalla ratkomassa projektin kuluessa esiintyneitä teknisiä haasteita. Missään vaiheessa ei syntynyt ns. terävää päätyä.

Ryhmähenki ja hyvä kommunikointi nousi esille jokaisessa sprintin päätteeksi pidetyssä retrospektiivissä. Kuvaavaa on, että näissä tapaamisissa esitetyt negatiiviset asiat olivat luonteeltaan teknisiä. 


## Kohti uusia haasteita

Ryhmä ei pyrkinyt ohjelmistossaan täydellisyyteen. Tärkeämpää oli liike eteenpäin ja uudet haasteet. Koska projektin kesto oli lyhyt ja käytettävissä vain rajallisesti aikaa, korostuivat pienetkin hidasteet. Ryhmällä on käytettävissä yhteensä 20 miestyötuntia viikossa. Jos laite menee rikki, ja sen korjaamiseen kuluu 10 tuntia, kuluu puolet viikon työpanoksesta. Projekti tarjosikin paljon haasteita ja uusia tilanteita, joihin kaikkiin keksittiin jokin ratkaisu.

Projekti lähti liikkeelle siitä, että viisi suurimmaksi osaksi toisiaan tuntematonta henkilöä niputettiin yhteen ja heille annettiin tehtäväksi tuottaa toimiva sovellus asiakkaan toiveiden mukaan. Ryhmä voi olla tuotokseen tyytyväinen ja parasta lienee se, että projekti toteutettiin hyvässä ja kannustavassa ilmapiirissä alusta loppuun. 

## Mitä tekisimme toisin?

Tämä on helppo. Käyttäisimme Mavenia.



Ketterä kvartetti:
Kasimir Aula
Eero Kalaja
Petri Kallio
Henrik Lyra
Raine Rantanen
