# AppVisor

Для проверки наличия SSE 4.2, выполните:

grep -q sse4_2 /proc/cpuinfo && echo "SSE 4.2 supported" || echo "SSE 4.2 not supported"

добавляем репозитории:
sudo nano /etc/apt/sources.list

добавить первой строкой(если trusty,иначе изменить на xenial или precise)
deb http://repo.yandex.ru/clickhouse/trusty stable main

/*ctrl+O; ctrl+x*/

sudo apt-key adv --keyserver keyserver.ubuntu.com --recv E0C56BD4    # optional
sudo apt-get update
sudo apt-get install clickhouse-client clickhouse-server-common

запускаем сервер 

sudo service clickhouse-server start

создаем таблицу для логов:

clickhouse-client
CREATE TABLE ControlClick (DateAndTime DateTime, sessionId String, eventId Int32, ControlId String, ScreenId String) ENGINE = Log

