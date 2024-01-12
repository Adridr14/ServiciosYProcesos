import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * ****************************************************************************
 * clase no instanciable donde se definen algunos valores finales
 *
 * @author Instituto Monte Naranco
 */
public class Paginas {
    //
    public static final String primeraCabecera =
            "Content-Type:text/html;charset=UTF-8";


    //contenido index
    public static final String html_index = "<html>"
            + "<head><title>index</title></head>"
            + "<body>"
            + "<h1>¡Enhorabuena!</h1>"
            + "<p>Tu servidor HTTP mínimo funciona correctamente<br></p>"
            +"<h2>Páginas interesantes:</h2>"
            + "<br><a href=\"http://localhost:8066/quijote\">El Quijote - Miguel de Cervantes</a>"
            + "</body>"
            + "</html>";
    //contenido quijote

    public static final String html_admin_index = "<html>"
            + "<head><title>admin</title></head>"
            + "<body>"
            + "<h1>¡Bienvenido a la sección de admin!</h1>"
            + "</body>"
            + "</html>";
    public static final String html_unknown_user = "<html>"
            + "<head><title>index</title></head>"
            + "<body>"
            + "<h1>Nombre de usuario desconocido o contraseña incorrecta</h1>"
            + "<p>Realize el inicio de sesión nuevamente</p>"
            + "</body>"
            + "</html>";
    public static final String html_quijote = "<html>"
            + "<head><title>quijote</title></head>"
            + "<body>"
            + "<h1>Así comienza el Quijote</h1>"
            +"<h2><br>Capítulo 1:</h2>"
            + "<p>En un lugar de la Mancha, de cuyo nombre no quiero "
            + "acordarme, no ha mucho tiempo que vivía un hidalgo de los "
            + "de lanza en astillero, adarga antigua, rocín flaco y galgo "
            + "corredor. Una olla de algo más vaca que carnero, salpicón "
            + "las más noches, duelos y quebrantos (huevos con tocino) los "
            + "sábados, lentejas los viernes, algún palomino de añadidura "
            + "los domingos, consumían las tres partes de su hacienda. El "
            + "resto della concluían sayo de velarte (traje de paño fino), "
            + "calzas de velludo (terciopelo) para las fiestas con sus "
            + "pantuflos de lo mismo, y los días de entresemana se honraba "
            + "con su vellorí (pardo de paño) de lo más fino. Tenía en su "
            + "casa una ama que pasaba de los cuarenta, y una sobrina que "
            + "no llegaba a los veinte, y un mozo de campo y plaza, que "
            + "así ensillaba el rocín como tomaba la podadera...</p>"
            + "</body>"
            + "</html>";
    //contenido noEncontrado
    public static final String html_noEncontrado = """
            <html>
              <head><title>noEncontrado</title></head>
              <body>
                <h1>¡ERROR! Página no encontrada</h1>
                <p>La página que solicitaste no existe en nuestro servidor</p>
              </body>
            </html>
            """;
}