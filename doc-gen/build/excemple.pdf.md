# API Rest Example


<a name="overview"></a>
## Vue générale
API permettant de restituer des informations sur les clients.


### Information de version
*Version* : 1.0.0


### Information de contact
*Contact* : Support


### Information de licence
*Licence* : License of API  
*Licence URL* : API license URL  
*Conditions de service* : Terms of service


### Schéma d'URI
*Serveur* : localhost:8080  
*Chemin de base* : /


### Tags

* person-resource : API pour la gestion des personnes.




<a name="paths"></a>
## Ressources

<a name="person-resource_resource"></a>
### Person-resource
API pour la gestion des personnes.


<a name="createusingpost"></a>
#### Permet d'enregistrer une nouvelle personne
```
POST /person
```


##### Description
Enregistre la personne en base de données.<br/><br/>Le resultat de la requete contient une entete Location indiquant l'url pour la récupération du nouveau client.


##### Paramètres

|Type|Nom|Description|Schéma|
|---|---|---|---|
|**Body**|**person**  <br>*requis*|person|[Person](#person)|


##### Réponses

|Code HTTP|Description|Schéma|
|---|---|---|
|**200**|OK|Pas de contenu|
|**201**|Entité crée|Pas de contenu|
|**401**|Unauthorized|Pas de contenu|
|**403**|Forbidden|Pas de contenu|
|**404**|Not Found|Pas de contenu|
|**500**|Erreur interne serveur|Pas de contenu|


##### Consomme

* `application/json`


##### Produit

* `application/json`


##### Exemple de requête HTTP

###### Requête path
```
/person
```


###### Requête body
```json
{
  "identifier" : "string",
  "civilite" : "string",
  "nom" : "string",
  "nomMarital" : "string",
  "prenom" : "string",
  "adresse" : {
    "adresse1" : "string",
    "adresse2" : "string",
    "cp" : "string",
    "pays" : "string",
    "ville" : "string"
  }
}
```


<a name="findallusingget"></a>
#### Retourne l'ensemble des personnes
```
GET /person
```


##### Réponses

|Code HTTP|Description|Schéma|
|---|---|---|
|**200**|OK|< [Person](#person) > array|
|**401**|Unauthorized|Pas de contenu|
|**403**|Forbidden|Pas de contenu|
|**404**|Not Found|Pas de contenu|


##### Consomme

* `application/json`


##### Produit

* `application/json`


##### Exemple de requête HTTP

###### Requête path
```
/person
```


##### Exemple de réponse HTTP

###### Réponse 200
```json
[ {
  "identifier" : "string",
  "civilite" : "string",
  "nom" : "string",
  "nomMarital" : "string",
  "prenom" : "string",
  "adresse" : {
    "adresse1" : "string",
    "adresse2" : "string",
    "cp" : "string",
    "pays" : "string",
    "ville" : "string"
  }
} ]
```


<a name="findbyidusingget"></a>
#### Permet de rechercher une personne en fonction de son identifiant
```
GET /person/{id}
```


##### Paramètres

|Type|Nom|Description|Schéma|
|---|---|---|---|
|**Path**|**id**  <br>*requis*|Identifiant fonctionnel de la personne recherchée|string|


##### Réponses

|Code HTTP|Description|Schéma|
|---|---|---|
|**200**|OK|[Person](#person)|
|**401**|Unauthorized|Pas de contenu|
|**403**|Forbidden|Pas de contenu|
|**404**|Not Found|Pas de contenu|


##### Consomme

* `application/json`


##### Produit

* `application/json`


##### Exemple de requête HTTP

###### Requête path
```
/person/string
```


##### Exemple de réponse HTTP

###### Réponse 200
```json
{
  "identifier" : "string",
  "civilite" : "string",
  "nom" : "string",
  "nomMarital" : "string",
  "prenom" : "string",
  "adresse" : {
    "adresse1" : "string",
    "adresse2" : "string",
    "cp" : "string",
    "pays" : "string",
    "ville" : "string"
  }
}
```




<a name="definitions"></a>
## Définitions

<a name="adresse"></a>
### Adresse

|Nom|Description|Schéma|
|---|---|---|
|**adresse1**  <br>*requis*|Adresse (rue, avenue, boulevard)  <br>**Exemple** : `"string"`|string|
|**adresse2**  <br>*optionnel*|Information complementaire sur l'adresse  <br>**Exemple** : `"string"`|string|
|**cp**  <br>*requis*|Code Postal  <br>**Exemple** : `"string"`|string|
|**pays**  <br>*requis*|Pays  <br>**Exemple** : `"string"`|string|
|**ville**  <br>*requis*|Ville  <br>**Exemple** : `"string"`|string|


<a name="605fff256cf141cb844edf15ff9c872d"></a>
### Iterable«Person»
*Type* : object


<a name="c813fb93f098f0a075749fa53c58f4cf"></a>
### Optional«Person»

|Nom|Description|Schéma|
|---|---|---|
|**present**  <br>*optionnel*|**Exemple** : `true`|boolean|


<a name="person"></a>
### Person
Entité représentant une personne physique


|Nom|Description|Schéma|
|---|---|---|
|**adresse**  <br>*optionnel*|Adresse de la personne  <br>**Exemple** : `"[adresse](#adresse)"`|[Adresse](#adresse)|
|**civilite**  <br>*optionnel*|Civilite  <br>**Exemple** : `"string"`|string|
|**identifier**  <br>*optionnel*|Identifiant  <br>**Exemple** : `"string"`|string|
|**nom**  <br>*requis*|Nom  <br>**Exemple** : `"string"`|string|
|**nomMarital**  <br>*optionnel*|Nom marital  <br>**Exemple** : `"string"`|string|
|**prenom**  <br>*requis*|Prenom  <br>**Exemple** : `"string"`|string|





