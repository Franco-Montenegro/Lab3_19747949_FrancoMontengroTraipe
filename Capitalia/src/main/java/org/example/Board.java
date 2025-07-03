package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Board {
    private List<Property> propiedades;
    private List<Card> cartasComunidad;
    private List<Card> cartasSuerte;
    private int posicionCarcel;
    private int posicionesComunidad;
    private int posicionesSuerte;

    /*
    public Board(List<Property> propiedades, List<Card> cartasComunidad, List<Card> cartasSuerte,
                 int posicionCarcel, Set<Integer> posicionesComunidad, Set<Integer> posicionesSuerte) {
        this.propiedades = propiedades;
        this.cartasComunidad = cartasComunidad;
        this.cartasSuerte = cartasSuerte;
        this.posicionCarcel = posicionCarcel;
        this.posicionesComunidad = posicionesComunidad;
        this.posicionesSuerte = posicionesSuerte;
    }
    */
    public Board() {
        this.propiedades = new ArrayList<Property>();
        this.cartasComunidad = new ArrayList<Card>();
        this.cartasSuerte = new ArrayList<Card>();
        this.posicionCarcel = 10;
        this.posicionesComunidad = 7;
        this.posicionesSuerte = 17;
        cargarDatosIniciales();
    }

    public void agregarPropiedad(Property propiedad) {
        propiedades.add(propiedad);
    }

    public void agregarCartaComunidad(Card carta) {
        cartasComunidad.add(carta);
    }

    public void agregarCartaSuerte(Card carta) {
        cartasSuerte.add(carta);
    }

    public boolean esCasillaSalida(int posicion) {
        return posicion == 0;
    }

    public boolean esCasillaCarcel(int posicion) {
        return posicion == posicionCarcel;
    }

    // Getters para listas y posición de cárcel
    public List<Property> getPropiedades() {
        return propiedades;
    }
    public List<Card> getCartasComunidad() {
        return cartasComunidad;
    }
    public List<Card> getCartasSuerte() {
        return cartasSuerte;
    }
    public int getPosicionCarcel() {
        return posicionCarcel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== TABLERO CAPITALIA ===\n");

        sb.append("\nPropiedades:\n");
        for (Property prop : propiedades) {
            sb.append(prop).append("\n"); // Asegúrate de tener toString en Property
        }

        sb.append("\nCartas de Comunidad:\n");
        for (Card carta : cartasComunidad) {
            sb.append(carta).append("\n"); // Usa toString de Card/CartaComunidad
        }

        sb.append("\nCartas de Suerte:\n");
        for (Card carta : cartasSuerte) {
            sb.append(carta).append("\n"); // Usa toString de Card/CartaSuerte
        }

        sb.append("\nPosiciones especiales:\n");
        sb.append("Posición de la Cárcel: ").append(posicionCarcel).append("\n");
        sb.append("Casillas de Comunidad: ").append(posicionesComunidad).append("\n");
        sb.append("Casillas de Suerte: ").append(posicionesSuerte).append("\n");

        return sb.toString();
    }
    public void cargarDatosIniciales() {

        agregarPropiedad(new Property(1, "Pallet Town", 60, 20, null, 0,false));
        agregarPropiedad(new Property(2, "Viridian Forest", 60, 25, null, 0,false));
        agregarPropiedad(new Property(3, "Pewter City", 100, 30, null, 0,false));
        agregarPropiedad(new Property(4, "Mt. Moon", 120, 35, null, 0,false));
        agregarPropiedad(new Property(5, "Cerulean City", 140, 40, null, 0,false));
        agregarPropiedad(new Property(6, "Vermilion City", 160, 45, null, 0,false));
        agregarPropiedad(new Property(7, "Celadon City", 180, 50, null, 0,false));
        agregarPropiedad(new Property(8, "Saffron City", 200, 55, null, 0,false));
        agregarPropiedad(new Property(9, "Lavander Town", 220, 60, null, 0,false));
        agregarPropiedad(new Property(10, "Fuchsia City", 280, 70, null, 0,false));
        agregarPropiedad(new Property(11, "Unkown Dungeon", 400, 90, null, 0,false));
        agregarPropiedad(new Property(12, "Cinnabar Island", 320, 80, null, 0,false));
        agregarPropiedad(new Property(13, "Victory Road", 340, 85, null, 0,false));
        agregarPropiedad(new Property(14, "Indigo Plateau", 400, 90, null, 0,false));
        agregarPropiedad(new Property(15, "Unkown Dungeon", 400, 95, null, 0,false));

        agregarCartaSuerte(new CardSuerte(1, "Un Meowth salvaje usó Día de Pago. ¡Recibes $200!"));
        agregarCartaSuerte(new CardSuerte(2, "Capturaste un Weedle en el Bosque Verde. Véndelo por $100."));
        agregarCartaSuerte(new CardSuerte(3, "El Team Rocket te ha robado mientras dormías..."));
        agregarCartaSuerte(new CardSuerte(4, "Encuentras un Fósil raro en el Mt. Moon. Lo vendes en el mercado negro por $250."));
        agregarCartaSuerte(new CardSuerte(5, "Tu Bicicleta de Ciudad Azulona fue robada."));
        agregarCartaSuerte(new CardSuerte(6, "¡Tu Pokémon aprendió Surf! Avanzas 5 casillas."));
        agregarCartaSuerte(new CardSuerte(7, "Te perdiste en la Cueva Diglett. Retrocedes 3 casillas."));
        agregarCartaSuerte(new CardSuerte(8, "Un policía de Ciudad Celeste te confundió con un ladrón. ¡Vas a la cárcel!"));
        agregarCartaSuerte(new CardSuerte(9, "Tus Pokémon ganan un torneo de aficionados en Pueblo Lavanda."));
        agregarCartaSuerte(new CardSuerte(10, "Usas Cuerda Huida y huyes de un centro de detención."));

        agregarCartaComunidad(new CardComunidad(1, "El Profesor Oak te otorga una beca de investigación."));
        agregarCartaComunidad(new CardComunidad(2, "Te ofreciste como voluntario en el Centro Pokémon."));
        agregarCartaComunidad(new CardComunidad(3, "Has causado un apagón al usar demasiados ataques eléctricos."));
        agregarCartaComunidad(new CardComunidad(4, "Fuiste mordido por un Ekans. Gastos médicos."));
        agregarCartaComunidad(new CardComunidad(5, "Tu Charmander quemó parte de tu casa."));
        agregarCartaComunidad(new CardComunidad(6, "Tu rival Gary te humilla en combate. Paga por entrenamiento."));
        agregarCartaComunidad(new CardComunidad(7, "Encuentras una Pokémoneda antigua entre tus cosas."));
        agregarCartaComunidad(new CardComunidad(8, "Tu madre te envía dinero desde Pueblo Paleta."));
        agregarCartaComunidad(new CardComunidad(9, "Tu Snorlax bloqueó una ruta. Multa de tránsito."));
        agregarCartaComunidad(new CardComunidad(10, "Usas una MT especial que te permite evitar problemas legales."));
    }

}
