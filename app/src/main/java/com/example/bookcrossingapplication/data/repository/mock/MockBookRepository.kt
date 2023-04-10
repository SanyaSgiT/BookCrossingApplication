package com.example.bookcrossingapplication.data.repository.mock

import com.example.bookcrossingapplication.domain.Book
import com.example.bookcrossingapplication.domain.Genre

class MockBookRepository {
    private val list = listOf(
        Book(
            1,
            1,
            "Повесть о приключениях Артура Гордона Пима. Рассказы",
            "Повесть о приключениях Артура Гордона Пима - единственный законченный роман родоначальника триллеров Эдгара Алана По. Сам автор пытался выдать его за реальный документ, ведь роман начинается как обычное повествование о морских приключениях. Тем более странными и страшными становятся дальнейшие события, которые приводят к скорому концу, пропитанному ужасом необъяснимого.\n" +
                    "И хотя при жизни автора критики называли роман \"неудачей\", он стал самым переводимым произведением По. Перевод на французский был сделан Шарлем Бодлером. Другой француз - Жюль Верн - написал продолжение романа под названием \"Ледяной сфинкс\". Герберт Уэллс называл \"Повесть...\" одной из трех книг, особенно поразивших его детское воображение. \"Хребты безумия\" Говарда Лавкрафта полны аллюзий к приключениям Пима.\n" +
                    "Роман печатается в переводе Г. Злобина.\n" +
                    "\n" +
                    "Рассказы, вошедшие в сборник, демонстрируют все грани таланта Эдгара По - новатора, юмориста и мастера острого сюжета.\n",
            "https://img4.labirint.ru/rc/32f36cb8679af5baad1306b1c74e2d68/363x561q80/books92/912394/cover.jpg?1677584526",
            Genre.CLASSIC,
            "Эдгар Алан По"
        ),
        Book(
            2,
            1,
            "Гордость и предубеждение",
            "\"\\\"Гордость и предубеждение\\\" - самый популярный женский роман в мире, провозглашенный интернет-пользователями Великобритании одной из лучших книг всех времен и народов.\\n\" +\n" +
                    "\"Мистер Дарси - главный герой романа - стал для многих читательниц эталоном мужчины, благородный аристократ, который закрывает глаза на сословные предрассудки и женится по любви на женщине, стоящей гораздо ниже его по положению. На Элизабет Беннет, гордой, неприступной девушке, умной, начитанной и глубоко чувствующей.\\n\" +\n" +
                    "\"Несколько экранизаций, два сериала и армия поклонников по всему миру навеки вписали роман \\\"Гордость и предубеждение\\\" в летопись лучших историй о любви, побеждающей любые преграды.\\n\",\n",
            "https://img4.labirint.ru/rc/c2a9be570e190d4186657a7da16b68d0/363x561q80/books50/490162/cover.jpg?1612693509",
            Genre.CLASSIC,
            "Джейн Остен"
        ),
        Book(
            3,
            1,
            "Взгляни на дом свой, ангел",
            "Автобиографический роман \"Взгляни на дом свой, ангел\", изданный в 1929 году, - это удивительный калейдоскоп ярких воспоминаний Томаса Вулфа о детских и юношеских годах: о родине - городе Эшвилл (штат Северная Каролина), который скрывается в тексте за вымышленным Алтамонтом; о времени союза и распада семьи автора и непростых взаимоотношениях ее членов; о первых шагах человека в огромном и пугающем мире.\n",
            "https://img3.labirint.ru/rc/19aa4701c39feee643b89b86a69e4253/363x561q80/books94/932725/cover.jpg?1677587205",
            Genre.CLASSIC,
            "Томас Вулф"
        ),
        Book(
            4,
            1,
            "Таинственный сад",
            "Любимая классика сентиментальной литературы, история сироты Мэри Леннокс, нашедшей дверцу в удивительный заброшенный сад, который изменит и ее жизнь, и жизнь всех обитателей дома, - в новом оформлении в подарочной серии \"Коллекция\".\n" +
                    "Иллюстрации Татьяны Паянской, сотканные из линий и полутонов, рождают идеальное сочетание изысканной красоты и глубины объекта. Художнице с академическим образованием, с немного нестандартной, но при этом классической подачей иллюстраций, легко удается передать эмоциональный фон произведений.\n" +
                    "Для детей среднего и старшего школьного возраста.\n",
            "https://img3.labirint.ru/rc/4b87679e29d41bcfafddbf94e78aa6e4/363x561q80/books74/739743/cover.jpg?1582698350",
            Genre.CLASSIC,
            "Фрэнсис Бёрнетт"
        ),
        Book(
            5,
            2,
            "Лоренс Даррелл: Александрийский квартет. Маунтолив.",
            "Четыре части романа-тетралогии \"Александрийский квартет\" носят имена своих главных героев. Читатель может посмотреть на одни и те же события глазами совершенно разных людей.\n" +
                    "Героем третьей книги - \"Маунтолив\" - становится второстепенный персонаж \"Бальтазара\", дипломат Маунтолив, имеющий весьма любопытное отношение к египетскому заговору.\n" +
                    "А о дальнейших судьбах персонажей первых трех книг тетралогии повествует часть четвертая, и заключительная - \"Клеа\", - действие которой происходит уже во время Второй мировой войны.\n" +
                    "Текст данного издания был переработан переводчиком В.Михайлиным и дополнен комментариями.\n" +
                    "Подробнее: https://www.labirint.ru/books/907710/",
            "https://img4.labirint.ru/rc/89e8c1f6b3a9497b995b51e189468f2c/363x561q80/books91/907710/cover.jpg?1677584198",
            Genre.CLASSIC,
            "Лоренс Даррелл"
        )
    )

    fun getAllBooks(): List<Book> = list

    fun findBooksByTitle(title: String) = list.filter { it.title.contains(title, true) }

    fun findBooksByOwnerId(id: Int): List<Book> = list.filter { it.ownerId == id }

    fun findBookById(id: Int): Book? = list.find { it.id == id }
}