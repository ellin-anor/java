import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkStrings {
    public static void main(String[] args) {
        // 4. Заменить все буквы в слове на строчные, а первую букву на заглавную
        //Например, дано hello, получаем Hello / дано HeLLO, получаем Hello

        Scanner input = new Scanner(System.in);
        System.out.println("Введите слово, используя заглавные и прописные буквы :");
        String inputWord = input.next();
        //System.out.println(inputWord);
        for (int i = 0; i < inputWord.length(); i++) {
            inputWord = inputWord.toLowerCase(); // в цикле привожу все буквы введенной строки к прописным
        }
        char[] arrayInputWord = inputWord.toCharArray(); // Преобразую строку в массив символов
        arrayInputWord[0] = Character.toUpperCase(arrayInputWord[0]); // Метод Character.toUpperCase() возвращает указанное значение типа char в верхнем регистре
        String newResult = new String(arrayInputWord); // В новую переменную записываю результат
        System.out.println(newResult);

       /* Найти количество вхождений одной строки в другую.
       Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза*/

        String stringFull; // строка, в которой будем искать другую строку
        String stringShort; // та строка, которую будем искать
        stringFull = "дом домик домой одомашненный";
        stringShort = "дом";
        int result = 0; // количество вхождений одной строки в другую

        // решение номер 1
        if (stringFull != stringShort) // если искомая строка не равна всей строке
            result = stringFull.split(stringShort).length; // то искомая строка используется как разделитель и результат равен длине полученного массива
        else result = 1; // иначе если строки равны, то выводить результат 1
        if (result > 1) // если результат больше 1, то выводить "полученное значение - 1"
            result = result - 1;

        System.out.println(result);


        // решение номер 2

        stringFull = "домaшний";
        stringShort = "дом";
        int result1 = 0;

        String[] stringFullWords = stringFull.split(" "); // создаем массив String и в качестве разделителя используем пробел
        for (int count = 0; count < stringFullWords.length; count++) {
            if (stringFullWords[count].contains(stringShort)) { // если индекс полученного массива равен искомой строке, то выводим "результат + 1"
                result1++;

            }
        }
        System.out.println(result1);

        /*Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины
        Например, в "в предложении все слова разной длины" самое длинное слово "предложении"*/

        String words = "в предложении все слова разной длины";
        String[] arrayWords = words.split(" "); // cоздать массив строк на основе разделителя - пробела
        int maxLength = 0;
        String maxWord = "";

        for (int s = 0; s < arrayWords.length; s++) {
            int currentWordLength = arrayWords[s].length();
            if (currentWordLength > maxLength) {
                maxLength = currentWordLength;// если текущая длина слова больше уже записаной, то обновляем переменную
                maxWord = arrayWords[s]; // Записываем в переменную
            }

        }
        System.out.println(maxWord);

        /*
        1 Заполнить массив
        Задать массив на N слов.
        В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        В итоге в массиве будут только уникальные слова.
        Выход из программы по слову exit (его в массив не добавлять) или если массив заполнен
        Перед завершением программы, вывести получившийся массив в консоль
        */

        String[] inputWords = new String[4];
        Scanner inWord = new Scanner(System.in);
        // цикл для добавления введённых пользователем слов в массив
        for (int i = 0; i < inputWords.length; i++) {
            System.out.println("Введите слово: ");
            String newWord = input.next();
            if (newWord.equals("exit")) {
                break;
            }
            boolean isWordAlreadyPresent = false;

            // цикл для проверки того, что слова нет в массиве
            for (int j = 0; j < inputWords.length && inputWords[j] != null; j++) {
                if (inputWords[j].equals(newWord)) {
                    isWordAlreadyPresent = true;
                    break;
                }
            }
            if (!isWordAlreadyPresent) {
                inputWords[i] = newWord;
            }
        }

        System.out.println(Arrays.toString(inputWords));

        System.out.println(IsPalindrom("Крошка енот"));

    }

    private static boolean IsPalindrom(String checkWord) {
    /*
    Написать функцию, которая проверяет, является ли строка палиндромом.
Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром
     */

        checkWord = checkWord.replaceAll(" ", "").toLowerCase(); // убираем пробелы
        char[] charsCheckWord = checkWord.toCharArray(); // преобразуем строку в массив
        for (int i = 0; i < charsCheckWord.length; i++) {
            if (charsCheckWord[i] != charsCheckWord[charsCheckWord.length - i - 1]) { // если текущий символ не равен символу (длина - индекс -1)
                return false; // возвращаем false
            }
        }

        return true; // если символы равны в течение всего цикла, возвращаем true
    }


}
