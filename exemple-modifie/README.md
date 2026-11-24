# Patron Singleton – Exemple modifié

Devoir n°3 – Patrons de construction (INF461)
TIENTCHEU TCHOKOUATOU Emmanuel – 20Q2998

## Idée

On applique le patron Singleton à un **journal (logger)** : toutes les parties
de l'application écrivent leurs messages dans le même journal. Il ne doit
exister qu'une seule instance de `Journal`, sinon les messages seraient
dispersés dans plusieurs objets et leur numérotation serait fausse.
