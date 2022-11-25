# MisRecetasApplication

Kotlin.
Aplicativo en donde se consume un servicio usando principios solid y arquitectura mvvm.

Servicio realizado en nodejs
Imágenes subidas en AWS S3
http://ec2-3-95-227-60.compute-1.amazonaws.com:3101/test_recipe

========= VISTAS =========
- Splash 
- Home Scren Activity 
  -> Lista de recetas con buscador por nombre o detail
     - La lista se guarda y actualiza en memoria cada vez que se llama al service (on resume) para que el usuario no espere la respuesta(solo pa primera vez).
     - Al hacer click en el item muestra el detalle
     - Al ser poca data se le envía por bundle para que el pintado sea rápido.
  -> Popup cuando tapea la imagen y permite hacer zoom
     Detalle.
- Detail Screen Activity
  -> Es un colapsing toolbar
  -> Recibe la data por bundle.
  -> Uso de onSaveInstanceState y onRestoreInstanceState para guardar y recuperar la data por si el usuario pasa mucho tiempo fuera del app, ya que se reinicia todo.
- Map Screen Activity
  -> Uso de Markers y zoom controls.
  -> Recibe la data por bundle.
  -> Uso de onSaveInstanceState y onRestoreInstanceState para guardar y recuperar la data por si el usuario pasa mucho tiempo fuera del app, ya que se reinicia todo.
=========================

![alt text](https://yp-challenge.s3.amazonaws.com/WhatsApp+Image+2022-11-25+at+5.56.53+AM+(2).jpeg)
![alt text](https://yp-challenge.s3.amazonaws.com/WhatsApp+Image+2022-11-25+at+5.58.49+AM.jpeg)
![alt text](https://yp-challenge.s3.amazonaws.com/WhatsApp+Image+2022-11-25+at+5.56.53+AM+(1).jpeg)
![alt text](https://yp-challenge.s3.amazonaws.com/WhatsApp+Image+2022-11-25+at+5.56.53+AM.jpeg)
![alt text](https://yp-challenge.s3.amazonaws.com/WhatsApp+Image+2022-11-25+at+5.56.53+AM+(3).jpeg)


- SOLID 
  -> activity, response base (herencia, polimorfismo, abstracción, encapsulamiento)
  -> utils (responsabilidad única, helpers, extensiones, dialogs)
- MVVM 
  -> prog. reactiva suscrita a un live data.
  -> data
    -> modelos
    -> repository
    -> network(services, api client)
  -> domain
    -> use case
  -> ui
    -> vistas agrupadas por features
  
- Shared Preferences guardando la lista para emular persistencia de datos.
- Maps
- Inyección de dependecias con dagger hilt.

=== MAIN LIBRARIES ===
- Retrofit
- Coroutines
- View model
- Live data
- Dagger Hilt
- Coil para las imágenes (usado en una extensión)
