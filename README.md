Tetris
==============

Composition du groupe
--------------
Chafik CISSE

Clément DALBERGUE

NICOLAS HEC

Classe : 41UFA


Contexte
--------------
 
Le projet d’Architecture Logiciel sur lequel nous avons travaillé, porte sur un Tetris basique. Ce projet réalisé en groupe de 3 étudiants a pour finalité la validation des connaissances acquises dans le cours d’Architecture logiciel et ainsi que le cours de programmation en JAVA par leur mise en application.

Nous allons présenter l’architecture qui va être mise en place afin de concevoir ce Tetris
 
Choix de l’Architecture
--------------
 
Afin de réaliser un Tetris basique, nous devons, premièrement, être capables de créer un Plateau qui représentera notre espace de Jeu. Ce Plateau sera un tableau, définit par X lignes et Y colonnes.

Par la suite, nous devrons définir une fonction (Lecteur d’Input) qui nous permettra de lire les données tout simplement envoyées par le clavier.

La troisième étape concernera la création de l’ensemble de pièces qui nous permettront de jouer, les Tetriminos. 3 paramètres ont été définis :

-        La taille
-        La forme
-        L'orientation
 
Comme pour tout jeu, et  surtout un Tétris, un gestionnaire des scores sera crée. Il associera simplement le score de l’utilisateur et son pseudo.

Pour terminer, nous devons utiliser un Gestionnaire des vues permettant d’alterner entre les différentes vues (Exemples : Menu, Mode multi-joueurs…).
 
Pour résumer, Notre architecture suivra les étapes suivantes :
-          Création d’une plateforme pour le jeu
-          Lecteur d’Input
-          Définition des pièces
-          Gestionnaire des scores
-          Gestionnaire des vues
 
Design Pattern
--------------

Utilisation du Design Pattern ArrayList, qui représente un tableau d’objets extensibles, que nous pouvons agrandir ou rétrécir à la demande.

Dans notre cas, nous avons, avec l’aide de ce Design Pattern, défini un tableau ArrayList<Point2D>. Ce tableau sera rempli de points qui détermineront la position du Tetriminos dans la grille.

Nous devrons mettre que des Point2D dans ce tableau car dans le cas contraire, Si nous mettons un objet différent, nous aurons une erreur lors de la compilation.
 
Features
--------------
7 Tétriminos différents ont été définis dans notre code. En fonction du Tetrimino, le joueur pourra effectuer la rotation qu’il voudra, et le faire bouger dans le sens de son choix.

Après insertion dans le tableau, le Tetrimino descendra tout seul et une fois arrivé à destination, un nouveau Tetrimino s’initialisera dans notre Plateau.

Une fois qu’une ligne est complète, le score de l’utilisateur augmentera et la ligne se supprimera. En conséquence, les lignes au dessus de la ligne supprimée seront automatiquement décalées vers le bas.
 
Lancement du Tetris
--------------
Installation : ./install.sh
Lancement : ./play.sh
 
Commandes :
 
- → : Déplacement à droite
- ← : Déplacement à gauche
- ↓ : Déplacement vers le bas
- ↑ : Rotation de la pièce




