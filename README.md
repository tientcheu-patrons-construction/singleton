# Patron Singleton

Devoir n°3 – Patrons de construction (INF461)
TIENTCHEU TCHOKOUATOU Emmanuel – 20Q2998

Organisation GitHub : https://github.com/tientcheu-patrons-construction

## Principe

Le patron **Singleton** est un patron de construction. Il garantit qu'une classe
n'a **qu'une seule instance** et donne un point d'accès global à cette instance.

Il repose sur trois éléments :

- un **constructeur privé** : personne ne peut faire `new` depuis l'extérieur ;
- un **attribut statique privé** qui contient l'unique instance ;
- une **méthode statique publique** qui crée l'instance au premier appel
  (initialisation paresseuse) puis renvoie toujours la même.

La classe est aussi déclarée `final` pour qu'aucune sous-classe ne puisse
contourner ces règles.

## Contenu du dépôt

| Dossier | Description |
|---|---|
| `exemple-cours/` | Exemple vu en cours : classe `Singleton` (calculs sur des entiers) |
| `exemple-modifie/` | Exemple modifié : classe `Journal` (journal unique partagé par toute l'application) |



