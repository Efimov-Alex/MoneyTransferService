#Курсовой проект «Сервис перевода денег»

## Описание проекта

Необходимо разработать приложение — REST-сервис. Сервис должен предоставить интерфейс для перевода денег с одной карты на другую по заранее описанной спецификации.

Заранее подготовленное веб-приложение (FRONT) должно подключаться к разработанному сервису без доработок и использовать его функционал для перевода денег.

## Требования к приложению

- Сервис должен предоставлять REST-интерфейс для интеграции с FRONT.
- Сервис должен реализовывать все методы перевода с одной банковской карты на другую, описанные [в протоколе](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml).
- Все изменения должны записываться в файл — лог переводов в произвольном формате с указанием:
- даты;
- времени;
- карты, с которой было списание;
- карты зачисления;
- суммы;
- комиссии;
- результата операции, если был.

## Требования в реализации

- Приложение разработано с использованием Spring Boot.
- Использован сборщик пакетов gradle/maven.
- Для запуска используется Docker, Docker Compose .
- Код размещён на GitHub.
- Код покрыт юнит-тестами с использованием mockito.
- Добавлены интеграционные тесты с использованием testcontainers.

Шаги реализации:

1. Изучить протокол получения и отправки сообщений.
1. Нарисовать схему приложений.
1. Описать архитектуру приложения, где хранятся настройки, описать формат хранения данных о картах.
1. Создать репозиторий проекта на GitHub.
1. Протестировать приложение с помощью curl/postman.
1. Написать Dockerfile и создать контейнер.
1. Написать Docker Compose  скрипт для запуска FRONT и написанного REST-SERVICE.
1. Протестировать запуск с помощью Docker Compose и интеграцию с FRONT.
1. Написать README.md к проекту, где описать команду запуска, порт и примеры запросов.
1. Отправить на проверку.

## Описание интеграции с FRONT

FRONT доступен [по адресу](https://github.com/serp-ya/card-transfer). Можно скачать репозиторий и запустить Node.js приложение локально (в описании репозитория FRONT добавлена информация, как запустить) или использовать уже развёрнутое демо-приложение [по адресу](https://serp-ya.github.io/card-transfer/) (тогда ваш API должен быть запущен [по адресу](http://localhost:5500/)).
> Весь API FRONT был описан в соответствии [YAML](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml)
файла по спецификации OpenAPI (подробнее [по ссылке 1](https://swagger.io/specification/) и [ссылке 2](https://starkovden.github.io/introduction-openapi-and-swagger.html)).

При возникновении любых вопросов, пожалуйста, задавайте их преподавателю.

Успехов в разработке!

## Команда запуска и порт
Для запуска сервера нужно выполнить команды:
```
mvn install
```

И далее запустить проект командой:
```
docker-compose up
```
## Связь с FRONT
Для работы FRONT нужно открыть его по адресу
https://github.com/serp-ya/card-transfer

## Примеры работы программы

/confirmOperationTest
![img.png](img.png)

/transfer Test
![img_1.png](img_1.png)