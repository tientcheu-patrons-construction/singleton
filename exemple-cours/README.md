# Patron Singleton – Exemple du cours

Devoir n°3 – Patrons de construction (INF461)
TIENTCHEU TCHOKOUATOU Emmanuel – 20Q2998

## Principe

Le patron **Singleton** est un patron de construction. Il garantit qu'une classe
n'a **qu'une seule instance** et donne un point d'accès global à cette instance.

Il repose sur trois éléments :

- un **constructeur privé** : personne ne peut faire `new Singleton()` depuis
  l'extérieur ;
- un **attribut statique privé** `instance` qui contient l'unique instance ;
- une **méthode statique publique** `getInstance()` qui crée l'instance au premier
  appel (initialisation paresseuse) puis renvoie toujours la même.

La classe est aussi déclarée `final` pour qu'aucune sous-classe ne puisse
contourner ces règles.

## Classes

| Classe | Rôle |
|---|---|
| `Singleton` | La classe à instance unique. Elle fournit `afficher()`, `somme()`, `moyenne()` et `produit()`. |
| `App` | Le client : il récupère l'instance avec `getInstance()` et l'utilise. |

## Points importants

- Il y a deux constructeurs privés et deux méthodes `getInstance()` : sans
  paramètre, ou avec `x` et `y`.
- Les paramètres de `getInstance(x, y)` ne servent **qu'à la première création**.
  Si l'instance existe déjà, elle est renvoyée telle quelle et les nouvelles
  valeurs sont ignorées.
- `clone()` est redéfinie pour lever `CloneNotSupportedException` : on ne peut pas
  obtenir une deuxième instance par clonage.

## Analyse : choix du modèle

Le modèle générique du Singleton (constructeur privé, instance statique, accès
par `getInstance()`) est appliqué tel quel. La classe ne fait que fournir des
services de calcul et n'a pas besoin de plusieurs objets. Avoir une seule
instance, partagée par tout le programme, évite de créer des objets inutiles.



## Sortie attendue

```
La somme de 5 et 10 est : 15
Singleton instance: x = 0, y = 0
Singleton instance: x = 0, y = 0
```

`s1`, `s2` et `s3` sont le même objet. Il a été créé par le premier appel
`getInstance()` (sans paramètre), donc `x` et `y` valent 0. Les valeurs `(3, 7)`
et `(16, 4)` sont ignorées : c'est la preuve qu'une seule instance existe.
