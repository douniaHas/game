# Reversi : 
Ce code est un exemple d'implémentation du jeu Reversi :\
http://codingdojo.org/kata/Reversi/ \

reversi/ReversiTest.java  : fichier de Tests unitaires \
reversi/TableJeu.java     : structure des données      \
reversi/Reversi.java      : fichier java métier        \
                                                       \
Pour compiler le code dans un terminal Linux:
```
$   javac -cp /usr/share/java/junit.jar reversi/*.java
```

Pour éxécuter les test unitaires dans un terminal Linux:
```
$   java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/core.jar org.junit.runner.JUnitCore reversi.ReversiTest
```

