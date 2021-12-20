import formHandler.register.RequestRegister;

/**
 * Iniciar este servidor apenas quando o ProcessServer for iniciado e o deploy
 * das piscinas Cliente, Corretora e Banco estiverem sido feitas.
 */
public class Application
{
    public static void main(String args[]) {
        RequestRegister.externalTaskClientRegisterRequest();
    }
}
