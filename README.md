#Heros of Might and Magic játék
##Üdvözöllek a játékomban!
###A játék beüzemelése

A játék Java 17-es verziójában íródott, így a futtatáshoz szükséged lesz egy fordítóra,
ami kezelni tudja ezt.

Mivel a játék elkészítéséhez JavaFx-et is használtam, ezért ez is rá kell, hogy legyen
telepítve a futtatásához. Szintén a 17-es verzióra lesz szükség. Ez utóbbi telepítésének
menete:
1. Felmész a következő linkre: https://gluonhq.com/products/javafx/
2. Lejjebb görgetve a Downloads-hoz kiválasztod a megfellő szűrőket
A verziónál válaszd a 17.0.2-eset. Az Operációs rendszernél válaszd ki milyen operációs
rednszer van a számítógépeden. Az architektúránál válaszd ki, hogy hány bites a rendszered.
Végül a típusnál válaszd az SDK-t. Így eredményül egyetlen lehetőséget fog feldobni. Ezt
kell letöltened a zöld Download gomb segítségével.
3. Így letölt neked egy .zip kiterjesztésű fájlt, amit ki kell csomagolnod egy tetszőleges mappába.
4. Ez tartalmazni fog egy .jar kiterjesztésű fájlt. Ezt kell lefuttatnod. Győződj meg róla,
hogy ezt közvetlen a terminálból (windowson cmd) teszed!
5. Ezután lépj be az imént kicsomagolt mappába. Ott látni fogsz egy lib nevű mappát.
Ebbe is lépj bele és másold ki fentről az elérési útvonalát.
6. Végül írd be a következő sort a terminálba/cmd-be bemásolva az imént 
lecopy-zott sort a megfelelő helyre: java --module-path "_IDE MÁSOLD BE AZ ELÉRÉSI 
ÚTVONALAT_" --add-modules javafx.controls,javafx.fxml -jar game.jar

###Nehézségi szintek
Kérlek válassz nehézségi szintet!
1. Könnyű: 1300 arany
2. Közepes: 1000 arany
3. Nehéz: 700 arany
###Tulajdonságok
A hősőd mostmár rendelkezik bizonyos mennyiségű arannyal.
Ezen túl rendelkezik hat másik tulajdonsággal:
1. **Támadás:** az egységek sebzését növeli meg, tulajdonságpontonként 10%-kal.
2. **Védekezés:** az egységeket ért sebzést csökkenti, tulajdonságpontonként 5%-kal.
3. **Morál:** az egységek kezdeményezését növeli, tulajdonságpontonként 1-gyel.
4. **Varázserő:** a hős által idézett varázslatok er®sségét növeli.
5. **Tudás:** a hős maximális mannapontjait növeli, tulajdonságpontonként 10-zel.
6. **Szerencse:** az egységek kritikus támadásának esélyét növeli, tulajdonságpontonként 5%-
   kal.

Alapértelmezetten mindegyik tulajdonságra 1 tulajdonságpont van elosztva, de aranyért vehetsz többet is,
minden tulajdonságra maximum 10-et. Minden tulajdonságpont ára egyre nagyobb.

**Ajánlatos okosan költeni az aranyat, mert varázslatokat és egységeket is ebből fogsz vásárolni később!**

###Varázslatok
Varázslatokat is tudsz vásárolni a hősődnek. Öt varázslat létezik, ezek közül
szabadon választhatsz bármennyit (megveheted akár mindegyiket vagy egyiket sem),
de egy varázslatot nem tudsz többször megvenni.

Minden varázslatnak van egy mannaköltsége. Ez később, a csata menete alatt lesz fontos,
 mivel egy varázslatot akárhányszor fel tudsz majd használni, amég el nem fogy a mannád.

A varázslatok leírása:
1. **Villámcsapás:** Egy kiválasztott ellenséges egységre a hősőd varázserő tulajdonsága * 30 sebzés okozása.
2. **Tűzlabda:** Egy kiválasztott mező körüli 3x3-as területen lévő összes 
(saját, illetve ellenséges) egységre a hősöd varázsereje * 20 sebzés okozása.
3. **Feltámasztás:** Egy kiválasztott saját egység feltámasztása. 
Maximális gyógyítás mértéke: hősőd varázserő tulajdonsága * 50. (De az eredeti egységszámnál több nem lehet!)
4. **Mágikus nyílvessző:** Egy kiválasztott egységre (varázserő * 10 + 10) sebzés okozása.
5. **Erősítés:** Megnöveli eggyel egy kiválasztott saját egység maximális sebzését.

A varázslatok költségei:

| Név                | Arany ár | Manna ár |
|--------------------|----------|-------|
| Villámcsapás       |60| 5     |
| Tűzlabda           |120|9      |
| Feltámasztás       |120| 6     |
| Mágikus nyílvessző |50| 15  |
| Erősítés           |100|4|

**Ajánlatos itt is okosan költeni az aranyat, mert még egységeket is kell 
majd vásárolnod!**

###Frakciók

Kérlek válassz frakciót!

Ezzel csupán annyit döntesz el, hogy milyen fajta egységek közül szeretnél
választani. Nincs jelentősége, csak a játékélmény javítására szolgál.

A lehetőségeid:
1. Élőholtak
2. Emberek
3. Repülő lények

###Egységek
Kérlek állítsd össze a sereged!

Írd be a megfelelő rublikába, hogy hány darabot szeretnél venni az adott
egységekből, majd katt a megveszem gombra. Nem muszáj mindegyikből
vásárolnod, de minimum egy egységet venned kell, hogy elkezdhesd a csatát.

Éhőholt egységek listája:

| Név | Ár   | Minimum sebzés | Maximum sebzés | Életerő | Sebesség | Kezdeményezés | Speciális képesség |
|-----|------|--------------|--------------|-------|--------|-------------|--------------------|
|Démon| 6    |2|3|30|5|9| nincs              |
|Szellem| 8    |1|1|30|5|15| nincs              |
|Vámpír| 7    |2|2|9|30|20| szupersebesség     |
|Zombi| 12   |1|4|9|1|6| nincs              |
|Vérfarkas| 15   |9|11|6|10|4| nincs              |

Emberi egységek listája:

| Név       | Ár  | Minimum sebzés | Maximum sebzés | Életerő | Sebesség | Kezdeményezés | Speciális képesség |
|-----------|-----|----------------|----------------|---------|----------|---------------|--------------------|
| Földműves | 2   | 1              | 1              | 3       | 4        | 8             | nincs              |
| Gróf      | 8   | 3              | 4              | 5       | 7        | 15            | nincs              |
| Íjász     | 6   | 2              | 4              | 7       | 4        | 9             | lövés              |
| Lovag     | 10  | 6              | 8              | 8       | 2        | 1             | nincs              |
| Polgár    | 6   | 7              | 9              | 6       | 9        | 3             | nincs              |

Repülő lény egységek listája:

| Név        | Ár  | Minimum sebzés | Maximum sebzés | Életerő | Sebesség | Kezdeményezés | Speciális képesség     |
|------------|-----|----------------|----------------|---------|----------|---------------|------------------------|
| Griff      | 15  | 5              | 10             | 30      | 7        | 15            | végtelen visszatámadás |
| Sarkany    | 10  | 8              | 12             | 15      | 5        | 3             | tűzokádás              |
| Főnix      | 12  | 15             | 25             | 40      | 6        | 4             | nincs                  |
| Pteranodon | 15  | 5              | 30             | 7       | 9        | 10            | nincs                  |
| Pegazus    | 7   | 2              | 2              | 30      | 7        | 8             | nincs                  |

Speciális képességek magyarázata:

Szupersebesség: A sebessége annyira magas, hogy bármekkorát léphetsz vele a csatatéren.

Lövés: Olyan egységet is meg tud támadni, ami nincs a közvetlen közelében.

Tűzokádás: Olyan egységet is meg tud támadni, ami nincs a közvetlen közelében.

Mielőtt tovább lépnél válaszd ki, hova szeretnéd lehelyezni a megvásárolt 
egységeid. Csak az első két oszlopban helyezheted el őket. Mindegyik egység 
pontosan egy mezőt foglal el. Ugyanazon mezőre nem kerülhet több egység.

###Csata
Kezdődjék a csata!

A tovább gomb megnyomása után megjelenik előtted a csatatér. A 12*10-es pálya első
két oszlopának megfelelő mezőire lehelyeződnek az egységeid. A meglévő varázslataidat
a pálya mellett bal oldalon találod felsorolva.

A program legenerálja az ellenfél tulajdonságait és varázslatait. 
Ezeket a csatatér mellett jobb oldalon tekintheted meg. Ilyenkor választ magának 
egységeket is, melyeket rögtön le is helyez a pálya utolsó két oszlopának celláiba.
A játék piros kerettel jelöli az ellenséges, sárga kerettel a saját, és zöld kerettel
az éppen soron következő egységet.

A csata körökre van osztva. Minden körben egy egység egy alkalommal lép. Először lépnek a 
magasabb kezdeményezésű egységek, majd pedig az alacsonyabb kezdeményezésű egységek.
A hősök tetszőleges időpontban cselekedhetnek, de körönként legfeljebb csak egyszer.
Tehát ha a te egyik egységed következik, akkor dönthetsz úgy, hogy először a hősöd használod
és csak utána lépsz az adott egységgel. Természetesen ugyanerre a gépi ellenfélnek is van
lehetősége.

A hős nem foglal helyet a csatatéren és nem lehet megölni. A hős kétféle cselekvést tud
végezni: támadás, illetve varázslás. A kettő közül egy körben csak az egyiket tudja
elvégezni.
1. **Támadás:** Egy kiválasztott ellenséges egységre mér adott mértékű 
(hős támadás tulajdonsága * 10) sebzést. Ehhez kattints jobb gombbal a megtámadni kívánt 
ellenséges egységre!
2. **Varázslás:** Tartsd lenyomva a megfelelő billentyűt miközben bal gombbal a kiválasztott
egységre klikkelsz. Csak akkor fog működni a varázslat, ha van hozzá elég mannád
és meg is vásároltad az adott varázslatot előzetesen aranyért.

**Varázslat billenytűkombinációk:**

' V ' + bal klikk = villámcsapás

' T ' + bal klikk = tűzlabda

' F ' + bal klikk = feltámasztás

' N ' + bal klikk = mágikus nyílvessző

' E ' + bal klikk = erősítés


Egy adott egység, amikor rá kerül a sor, akkor három dolgot tud csinálni: 
mozogni, várakozni, illetve támadni. Ezek közül egy körben csak az egyiket tudja csinálni.

1.**Mozgás:** az egység pozíciót vált a játékmezőn ("arrébb megy"). Ehhez kattints bal 
gombbal arra az üres mezőre, ahová lépni szeretnél. Legfeljebb annyi mezőt tud mozogni
az egységed, amennyi a sebessége. A mozgás iránya tetszőleges, akár jobbra, balra,
fel, le, átlósan, kacskaringósan (pl. ha más egységet kell kikerülni) történhet.

2.**Várakozás:** az egység az adott körből kimarad. Ehhez nyomd meg a bal felső
sarokban található "várakozás" gombot.

3.**Támadás:** egy ellenséges egység megtámadása. Ehhez kattints bal gombbal arra
az ellenséges egységre, amit meg szeretnél támadni. Közelharci támadás csak szomszédos 
egység ellen indítható, míg távolsági támadás csak akkor indítható, ha az egység
közvetlen környezetében nincs ellenséges egység. Ez utóbbira csak az íjász képes.

A játék akkor ér véget, ha az egyik hős összes egysége meghal. Amennyiben egyszerre halnak meg
mindkét hős egységei, a játék döntetlennel zárul.
