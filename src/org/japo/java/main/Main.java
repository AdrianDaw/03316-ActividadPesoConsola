/* 
 * Copyright 2019 Adrián Pérez Rodríguez - adrianp899@gmail.com .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {

        // REFERENCIAS
        final int PESO_MIN = 0;   // Peso minimo
        final int PESO_MAX = 250;  // Peso maximo
        final int CUENTA_INI = 1;   // Para numero de dias
        final int CUENTA_FIN = 8;   // Para numero de dias
        int pesoAct = 0;
        int peso1 = 0;
        int peso2 = 0;
        int peso3 = 0;
        int peso4 = 0;
        int peso5 = 0;
        int peso6 = 0;
        int peso7 = 0;
        int pesoMedio = 0;

        // CABECERA
        System.out.println("CONTROL DE PESO");
        System.out.println("---------------");

        // BUCLE cuenta los dias
        for (int dia = CUENTA_INI; dia < CUENTA_FIN; dia++) {

            // CONTROL DE PLANTA
            boolean pesoOK;
            do {

                // CONTROL DE ENTRADA
                boolean testOK = false;
                do {
                    try {
                        System.out.printf("Peso dia %d: ", dia);
                        pesoAct = SCN.nextInt();
                        testOK = true;

                    } catch (Exception e) {
                        // MENSAJE ENTRADA INCORRECTA
                        System.out.println("ERROR: entrada incorrecta");
                    } finally {
                        SCN.nextLine();
                    }

                } while (!testOK);

                // CONTROL RANGO DE PESO
                pesoOK = pesoAct >= PESO_MIN && pesoAct <= PESO_MAX;

                // MENSAJE DE ERROR
                if (!pesoOK) {
                    System.out.println("Error: entrada incorrecta");
                }

                if (pesoOK && dia==1) {
                    peso1 = pesoAct;
                }
                if (pesoOK && dia==2) {
                    peso2 = pesoAct;
                }
                if (pesoOK && dia==3) {
                    peso3 = pesoAct;
                }
                if (pesoOK && dia==4) {
                    peso4 = pesoAct;
                }
                if (pesoOK && dia==5) {
                    peso5 = pesoAct;
                }
                if (pesoOK && dia==6) {
                    peso6 = pesoAct;
                }
                if (pesoOK && dia==7) {
                    peso7 = pesoAct;
                }
            } while (!pesoOK);

            // MENSAJE SALIDA ALINTRODUCIR PLANTA CORRECTA
            System.out.printf("Ud. ha introducido %d kg en el dia %d\n", pesoAct, dia);
        }
        // OPERACION
        pesoMedio = (peso1+peso2+peso3+peso4+peso5+peso6+peso7)/7;
        // MENSAJE PROCESO COMPLETADO
        System.out.println("----------------------------------------------");
        System.out.printf("Peso medio durante la semana..: %d%n", pesoMedio);
    }
}
