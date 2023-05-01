import java.security.MessageDigest;

public class PruebaDeco {

    private String passwordHash;
    private String algoritmo;
    private long tiempo;
    private String[] alfabeto;
    private String prefijoInicial;
    private static boolean encontrado;

    public PruebaDeco (String passwordHash, String algoritmo, long tiempo, String[] alfabeto, String prefijo) {
        this.passwordHash = passwordHash;
        this.algoritmo = algoritmo;
        this.tiempo = tiempo;
        this.alfabeto = alfabeto;
        encontrado = false;
    }
    
    public void generarCombinaciones(String prefijo, String[] alfabeto) 
    {
        tiempo = System.nanoTime();
        if (prefijo.length() <= 7)
        {
            for (int i = 0; i < alfabeto.length; i++) {
                if (encontrado == false)
                {
                    match(prefijo);
                    String nuevaCombinacion = prefijo + alfabeto[i];
                    generarCombinaciones(nuevaCombinacion, alfabeto);
                }
            }
        }
    }

    public void match(String guess)
    {
        byte[] bytesCadena = guess.getBytes();
        byte[] arreglo = null;
        String hexaGuess = "";

        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(bytesCadena);
            arreglo = md.digest();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        for (int i=0;i<arreglo.length;i++) {
            if ((arreglo[i] & 0xff) <= 0xf) {
                hexaGuess+="0";
            }
            hexaGuess += Integer.toHexString(arreglo[i] & 0xff);
        }

        if (hexaGuess.equals(passwordHash))
        {
            tiempo = System.nanoTime() - tiempo;
            encontrado = true;
            System.out.println("Se encontro la contraseña!!!!");
            System.out.println("Hash Contraseña Original: " + passwordHash);
            System.out.println("Hash Encontrado: " + hexaGuess);
            System.out.println("La contraseña es: " + guess);
            System.out.println("Tiempo de ejecucion en segundos: " + tiempo);
        }
    }
}
