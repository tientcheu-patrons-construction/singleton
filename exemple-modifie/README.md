# Patron Singleton – Exemple modifié

Devoir n°3 – Patrons de construction (INF461)
TIENTCHEU TCHOKOUATOU Emmanuel – 20Q2998

## Idée

On applique le patron Singleton à un **journal (logger)** : toutes les parties
de l'application écrivent leurs messages dans le même journal. Il ne doit
exister qu'une seule instance de `Journal`, sinon les messages seraient
dispersés dans plusieurs objets et leur numérotation serait fausse.

## Diagramme de classes

```
┌──────────────────────────────────────────────────┐
│                «final» Journal                   │
├──────────────────────────────────────────────────┤
│ - instance : Journal  {static}                   │
│ - messages : List<String>                        │
│ - compteur : int                                 │
├──────────────────────────────────────────────────┤
│ - Journal()                                      │
│ + getInstance() : Journal  {static}              │
│ + info(source, message : String) : void          │
│ + erreur(source, message : String) : void        │
│ - ecrire(niveau, source, message : String) : void│
│ + afficherHistorique() : void                    │
│ + getNombreMessages() : int                      │
│ + clone() : Object                               │
└──────────────────────────────────────────────────┘
                         ▲
                         │ utilise
┌────────────────────────┴─────────────────────────┐
│                       App                        │
├──────────────────────────────────────────────────┤
│ + main(args : String[]) : void  {static}         │
└──────────────────────────────────────────────────┘
```

Tout se passe dans `main` : le client récupère le journal deux fois avec
`Journal.getInstance()` (`j1` puis `j2`) et écrit des messages avec chacun.

## Classes

| Classe | Rôle |
|---|---|
| `Journal` | Le Singleton : l'unique journal, qui numérote et garde tous les messages. |
| `App` | Le client : dans `main`, il récupère le journal deux fois (`j1`, `j2`), écrit des messages, vérifie que `j1 == j2` et affiche l'historique. |

## Différences avec l'exemple du cours

| Exemple du cours (`Singleton`) | Exemple modifié (`Journal`) |
|---|---|
| Classe de calcul (`somme`, `moyenne`, `produit`) | Cas réel : journal des événements de l'application |
| `getInstance()` avec ou sans paramètres | Un seul `getInstance()` sans paramètre |
| Pas d'état partagé utile (`x`, `y`) | État partagé : liste des messages et compteur |

Le modèle reste celui du cours : constructeur privé, attribut statique privé
`instance`, méthode statique publique `getInstance()` qui crée l'instance au
premier appel puis renvoie toujours la même. La classe est `final` et `clone()`
lève une exception, pour empêcher toute copie.

## Analyse : choix du modèle

Un journal est un cas typique du Singleton : toute l'application doit écrire
au même endroit, dans l'ordre, sans que chaque classe ait à se passer l'objet.
`getInstance()` donne ce point d'accès global : n'importe quelle partie du
programme peut récupérer le journal elle-même. Si on pouvait créer plusieurs
journaux, chaque partie aurait
son propre historique et sa propre numérotation, et on perdrait la vue
d'ensemble. On garde donc le modèle générique du Singleton tel quel ; seul le
contenu de la classe change (une liste de messages et un compteur au lieu de
méthodes de calcul).

## Compilation et exécution

Avec un JDK installé, depuis ce dossier :

```bash
javac -d bin src/*.java
java -cp bin App
```

On peut aussi ouvrir le dossier dans VS Code (extension Java) et lancer `App.java`.

## Sortie obtenue

```
[JOURNAL] creation de l'unique journal
001 [INFO] Inscription : inscription de Alice
002 [INFO] Paiement : Alice a paye 50000 FCFA
003 [ERREUR] Inscription : dossier incomplet pour Bob
004 [INFO] Paiement : Carine a paye 25000 FCFA
j1 == j2 : true
nombre de messages : 4
----- Historique du journal (4 messages) -----
001 [INFO] Inscription : inscription de Alice
002 [INFO] Paiement : Alice a paye 50000 FCFA
003 [ERREUR] Inscription : dossier incomplet pour Bob
004 [INFO] Paiement : Carine a paye 25000 FCFA
```

- Le message `creation de l'unique journal` n'apparaît **qu'une fois**, alors que
  `getInstance()` est appelée deux fois (`j1` et `j2`).
- Les messages écrits avec `j1` (001, 002) et avec `j2` (003, 004) sont numérotés
  à la suite et se retrouvent dans le même historique de 4 messages : `j1` et
  `j2` sont bien le même objet.
- `j1 == j2` vaut `true`.
