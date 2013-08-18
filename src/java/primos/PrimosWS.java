/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "PrimosWS")
public class PrimosWS {

    @WebMethod(operationName = "ePrimo")
    public boolean ePrimo(int numero) {
        // 2 é o único número primo par
        if (numero == 2) {
            return true;
        }
        // número par não é primo
        if ((numero % 2) == 0) {
            return false;
        }

        // não é primo se for divisivel por qualquer número ímpar
        // que não 1 e ele mesmo
        for (int i = 3; i < ((numero + 1) / 2); i += 2) {
            if ((numero % i) == 0) {
                return false;
            }
        }

        // é primo
        return true;
    }

    @WebMethod(operationName = "primos")
    public String primos(int max) {
        String str = "";

        // verifica todos os números entre 2 e max
        for (int i = 2; i < max; i++) {
            if (ePrimo(i)) {
                str = str + Integer.toString(i) + " ";
            }
        }
        // retorna uma string com os números
        return str;
    }
}
