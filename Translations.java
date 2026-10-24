package com.example.settings;

import java.io.IOException;
import java.io.StringReader;
import java.util.EnumMap;
import java.util.Map;
import java.util.Properties;

/**
 * All text the plugin shows to players, in every supported language.
 * Missing keys fall back to English.
 */
public final class Translations {

    private static final String EN = """
menu.title=Settings
menu.on=ON
menu.off=OFF
menu.currently=Currently: %s
menu.toggle=Click to toggle
menu.close=Close
menu.language=Language
menu.language.hint=Click to change your language
lang.title=Language
lang.selected=Selected
lang.click=Click to select
lang.back=Back
lang.changed=Language changed to %s.
setting.all_chat.name=All Chat Messages
setting.all_chat.desc=Turn off to hide player chat, join/leave, advancement and death messages. Plugin messages and the MOTD still show. You can still send messages.
setting.public_chat.name=Public Chat
setting.public_chat.desc=Show chat messages sent by other players.
setting.join_quit.name=Join / Leave Messages
setting.join_quit.desc=Show messages when players join or leave.
setting.tpa_requests.name=TPA Requests
setting.tpa_requests.desc=Let other players send you teleport requests.
setting.advancements.name=Advancement Messages
setting.advancements.desc=Show messages when players earn advancements.
setting.mention_sound.name=Mention Sound
setting.mention_sound.desc=Play a sound when someone says your name in chat.
msg.public_chat_hidden=Public chat is now hidden. Use /settings to turn it back on.
msg.public_chat_blocked=You have public chat turned off. Use /settings to turn it back on.
msg.tpa_blocked=%s is not accepting teleport requests.
""";

    private static final String ES = """
menu.title=Ajustes
menu.on=ACTIVADO
menu.off=DESACTIVADO
menu.currently=Actualmente: %s
menu.toggle=Clic para cambiar
menu.close=Cerrar
menu.language=Idioma
menu.language.hint=Clic para cambiar tu idioma
lang.title=Idioma
lang.selected=Seleccionado
lang.click=Clic para seleccionar
lang.back=Atrás
lang.changed=Idioma cambiado a %s.
setting.all_chat.name=Todos los mensajes del chat
setting.all_chat.desc=Desactívalo para ocultar el chat de jugadores y los mensajes de entrada/salida, logros y muertes. Los mensajes de plugins y el MOTD se siguen mostrando. Aún puedes enviar mensajes.
setting.public_chat.name=Chat público
setting.public_chat.desc=Mostrar los mensajes de chat de otros jugadores.
setting.join_quit.name=Mensajes de entrada/salida
setting.join_quit.desc=Mostrar mensajes cuando los jugadores entran o salen.
setting.tpa_requests.name=Solicitudes TPA
setting.tpa_requests.desc=Permitir que otros jugadores te envíen solicitudes de teletransporte.
setting.advancements.name=Mensajes de logros
setting.advancements.desc=Mostrar mensajes cuando los jugadores consiguen logros.
setting.mention_sound.name=Sonido de mención
setting.mention_sound.desc=Reproducir un sonido cuando alguien dice tu nombre en el chat.
msg.public_chat_hidden=El chat público ahora está oculto. Usa /settings para volver a activarlo.
msg.public_chat_blocked=Tienes el chat público desactivado. Usa /settings para volver a activarlo.
msg.tpa_blocked=%s no acepta solicitudes de teletransporte.
""";

    private static final String FR = """
menu.title=Paramètres
menu.on=ACTIVÉ
menu.off=DÉSACTIVÉ
menu.currently=Actuellement : %s
menu.toggle=Cliquez pour basculer
menu.close=Fermer
menu.language=Langue
menu.language.hint=Cliquez pour changer de langue
lang.title=Langue
lang.selected=Sélectionnée
lang.click=Cliquez pour sélectionner
lang.back=Retour
lang.changed=Langue changée en %s.
setting.all_chat.name=Tous les messages du chat
setting.all_chat.desc=Désactivez pour masquer le chat des joueurs et les messages de connexion/déconnexion, de progrès et de mort. Les messages des plugins et le MOTD restent affichés. Vous pouvez toujours envoyer des messages.
setting.public_chat.name=Chat public
setting.public_chat.desc=Afficher les messages envoyés par les autres joueurs.
setting.join_quit.name=Messages de connexion / déconnexion
setting.join_quit.desc=Afficher un message quand un joueur se connecte ou se déconnecte.
setting.tpa_requests.name=Demandes de TP
setting.tpa_requests.desc=Autoriser les autres joueurs à vous envoyer des demandes de téléportation.
setting.advancements.name=Messages de progrès
setting.advancements.desc=Afficher un message quand un joueur obtient un progrès.
setting.mention_sound.name=Son de mention
setting.mention_sound.desc=Jouer un son quand quelqu'un dit votre pseudo dans le chat.
msg.public_chat_hidden=Le chat public est maintenant masqué. Utilisez /settings pour le réactiver.
msg.public_chat_blocked=Vous avez désactivé le chat public. Utilisez /settings pour le réactiver.
msg.tpa_blocked=%s n'accepte pas les demandes de téléportation.
""";

    private static final String DE = """
menu.title=Einstellungen
menu.on=AN
menu.off=AUS
menu.currently=Aktuell: %s
menu.toggle=Zum Umschalten klicken
menu.close=Schließen
menu.language=Sprache
menu.language.hint=Klicke, um deine Sprache zu ändern
lang.title=Sprache
lang.selected=Ausgewählt
lang.click=Zum Auswählen klicken
lang.back=Zurück
lang.changed=Sprache geändert zu %s.
setting.all_chat.name=Alle Chatnachrichten
setting.all_chat.desc=Ausschalten, um Spielerchat sowie Beitritts-, Fortschritts- und Todesnachrichten auszublenden. Plugin-Nachrichten und die MOTD werden weiterhin angezeigt. Du kannst weiterhin Nachrichten senden.
setting.public_chat.name=Öffentlicher Chat
setting.public_chat.desc=Chatnachrichten anderer Spieler anzeigen.
setting.join_quit.name=Beitritts-/Verlassen-Nachrichten
setting.join_quit.desc=Nachrichten anzeigen, wenn Spieler beitreten oder gehen.
setting.tpa_requests.name=TPA-Anfragen
setting.tpa_requests.desc=Anderen Spielern erlauben, dir Teleportanfragen zu senden.
setting.advancements.name=Fortschrittsnachrichten
setting.advancements.desc=Nachrichten anzeigen, wenn Spieler Fortschritte erzielen.
setting.mention_sound.name=Erwähnungston
setting.mention_sound.desc=Einen Ton abspielen, wenn jemand deinen Namen im Chat sagt.
msg.public_chat_hidden=Der öffentliche Chat ist jetzt ausgeblendet. Nutze /settings, um ihn wieder einzuschalten.
msg.public_chat_blocked=Du hast den öffentlichen Chat ausgeschaltet. Nutze /settings, um ihn wieder einzuschalten.
msg.tpa_blocked=%s nimmt keine Teleportanfragen an.
""";

    private static final String PT = """
menu.title=Configurações
menu.on=LIGADO
menu.off=DESLIGADO
menu.currently=Atualmente: %s
menu.toggle=Clique para alternar
menu.close=Fechar
menu.language=Idioma
menu.language.hint=Clique para mudar seu idioma
lang.title=Idioma
lang.selected=Selecionado
lang.click=Clique para selecionar
lang.back=Voltar
lang.changed=Idioma alterado para %s.
setting.all_chat.name=Todas as mensagens do chat
setting.all_chat.desc=Desative para ocultar o chat dos jogadores e as mensagens de entrada/saída, conquistas e mortes. Mensagens de plugins e o MOTD continuam aparecendo. Você ainda pode enviar mensagens.
setting.public_chat.name=Chat público
setting.public_chat.desc=Mostrar mensagens de chat enviadas por outros jogadores.
setting.join_quit.name=Mensagens de entrada/saída
setting.join_quit.desc=Mostrar mensagens quando jogadores entram ou saem.
setting.tpa_requests.name=Pedidos de TPA
setting.tpa_requests.desc=Permitir que outros jogadores enviem pedidos de teletransporte a você.
setting.advancements.name=Mensagens de conquistas
setting.advancements.desc=Mostrar mensagens quando jogadores ganham conquistas.
setting.mention_sound.name=Som de menção
setting.mention_sound.desc=Tocar um som quando alguém disser seu nome no chat.
msg.public_chat_hidden=O chat público agora está oculto. Use /settings para ativá-lo novamente.
msg.public_chat_blocked=Você desativou o chat público. Use /settings para ativá-lo novamente.
msg.tpa_blocked=%s não está aceitando pedidos de teletransporte.
""";

    private static final String IT = """
menu.title=Impostazioni
menu.on=ATTIVO
menu.off=DISATTIVO
menu.currently=Attualmente: %s
menu.toggle=Clic per cambiare
menu.close=Chiudi
menu.language=Lingua
menu.language.hint=Clic per cambiare lingua
lang.title=Lingua
lang.selected=Selezionata
lang.click=Clic per selezionare
lang.back=Indietro
lang.changed=Lingua cambiata in %s.
setting.all_chat.name=Tutti i messaggi della chat
setting.all_chat.desc=Disattiva per nascondere la chat dei giocatori e i messaggi di ingresso/uscita, progressi e morte. I messaggi dei plugin e il MOTD vengono comunque mostrati. Puoi comunque inviare messaggi.
setting.public_chat.name=Chat pubblica
setting.public_chat.desc=Mostra i messaggi di chat inviati dagli altri giocatori.
setting.join_quit.name=Messaggi di ingresso/uscita
setting.join_quit.desc=Mostra i messaggi quando i giocatori entrano o escono.
setting.tpa_requests.name=Richieste TPA
setting.tpa_requests.desc=Permetti agli altri giocatori di inviarti richieste di teletrasporto.
setting.advancements.name=Messaggi dei progressi
setting.advancements.desc=Mostra i messaggi quando i giocatori ottengono progressi.
setting.mention_sound.name=Suono di menzione
setting.mention_sound.desc=Riproduci un suono quando qualcuno dice il tuo nome in chat.
msg.public_chat_hidden=La chat pubblica ora è nascosta. Usa /settings per riattivarla.
msg.public_chat_blocked=Hai disattivato la chat pubblica. Usa /settings per riattivarla.
msg.tpa_blocked=%s non accetta richieste di teletrasporto.
""";

    private static final String NL = """
menu.title=Instellingen
menu.on=AAN
menu.off=UIT
menu.currently=Nu: %s
menu.toggle=Klik om te wisselen
menu.close=Sluiten
menu.language=Taal
menu.language.hint=Klik om je taal te wijzigen
lang.title=Taal
lang.selected=Geselecteerd
lang.click=Klik om te selecteren
lang.back=Terug
lang.changed=Taal gewijzigd naar %s.
setting.all_chat.name=Alle chatberichten
setting.all_chat.desc=Zet uit om spelerschat en berichten over betreden/verlaten, prestaties en sterfgevallen te verbergen. Pluginberichten en de MOTD blijven zichtbaar. Je kunt nog steeds berichten sturen.
setting.public_chat.name=Openbare chat
setting.public_chat.desc=Toon chatberichten van andere spelers.
setting.join_quit.name=Bericht bij betreden/verlaten
setting.join_quit.desc=Toon berichten wanneer spelers de server betreden of verlaten.
setting.tpa_requests.name=TPA-verzoeken
setting.tpa_requests.desc=Sta toe dat andere spelers je teleportverzoeken sturen.
setting.advancements.name=Prestatieberichten
setting.advancements.desc=Toon berichten wanneer spelers prestaties behalen.
setting.mention_sound.name=Vermeldingsgeluid
setting.mention_sound.desc=Speel een geluid af wanneer iemand je naam in de chat zegt.
msg.public_chat_hidden=De openbare chat is nu verborgen. Gebruik /settings om hem weer aan te zetten.
msg.public_chat_blocked=Je hebt de openbare chat uitgezet. Gebruik /settings om hem weer aan te zetten.
msg.tpa_blocked=%s accepteert geen teleportverzoeken.
""";

    private static final String RU = """
menu.title=Настройки
menu.on=ВКЛ
menu.off=ВЫКЛ
menu.currently=Сейчас: %s
menu.toggle=Нажмите, чтобы переключить
menu.close=Закрыть
menu.language=Язык
menu.language.hint=Нажмите, чтобы сменить язык
lang.title=Язык
lang.selected=Выбрано
lang.click=Нажмите, чтобы выбрать
lang.back=Назад
lang.changed=Язык изменён на %s.
setting.all_chat.name=Все сообщения чата
setting.all_chat.desc=Выключите, чтобы скрыть чат игроков, а также сообщения о входе/выходе, достижениях и смертях. Сообщения плагинов и MOTD по-прежнему отображаются. Вы всё равно можете отправлять сообщения.
setting.public_chat.name=Общий чат
setting.public_chat.desc=Показывать сообщения чата от других игроков.
setting.join_quit.name=Сообщения о входе и выходе
setting.join_quit.desc=Показывать сообщения, когда игроки заходят или выходят.
setting.tpa_requests.name=Запросы TPA
setting.tpa_requests.desc=Разрешить другим игрокам отправлять вам запросы на телепортацию.
setting.advancements.name=Сообщения о достижениях
setting.advancements.desc=Показывать сообщения, когда игроки получают достижения.
setting.mention_sound.name=Звук упоминания
setting.mention_sound.desc=Проигрывать звук, когда кто-то называет ваше имя в чате.
msg.public_chat_hidden=Общий чат скрыт. Используйте /settings, чтобы включить его снова.
msg.public_chat_blocked=У вас отключён общий чат. Используйте /settings, чтобы включить его снова.
msg.tpa_blocked=%s не принимает запросы на телепортацию.
""";

    private static final String PL = """
menu.title=Ustawienia
menu.on=WŁ.
menu.off=WYŁ.
menu.currently=Obecnie: %s
menu.toggle=Kliknij, aby przełączyć
menu.close=Zamknij
menu.language=Język
menu.language.hint=Kliknij, aby zmienić język
lang.title=Język
lang.selected=Wybrano
lang.click=Kliknij, aby wybrać
lang.back=Wstecz
lang.changed=Zmieniono język na %s.
setting.all_chat.name=Wszystkie wiadomości czatu
setting.all_chat.desc=Wyłącz, aby ukryć czat graczy oraz wiadomości o wejściu/wyjściu, osiągnięciach i śmierci. Wiadomości pluginów i MOTD nadal są wyświetlane. Nadal możesz wysyłać wiadomości.
setting.public_chat.name=Czat publiczny
setting.public_chat.desc=Pokazuj wiadomości czatu od innych graczy.
setting.join_quit.name=Wiadomości o wejściu/wyjściu
setting.join_quit.desc=Pokazuj wiadomości, gdy gracze dołączają lub wychodzą.
setting.tpa_requests.name=Prośby TPA
setting.tpa_requests.desc=Pozwól innym graczom wysyłać ci prośby o teleportację.
setting.advancements.name=Wiadomości o osiągnięciach
setting.advancements.desc=Pokazuj wiadomości, gdy gracze zdobywają osiągnięcia.
setting.mention_sound.name=Dźwięk wzmianki
setting.mention_sound.desc=Odtwarzaj dźwięk, gdy ktoś wspomni twój nick na czacie.
msg.public_chat_hidden=Czat publiczny jest teraz ukryty. Użyj /settings, aby go włączyć.
msg.public_chat_blocked=Masz wyłączony czat publiczny. Użyj /settings, aby go włączyć.
msg.tpa_blocked=%s nie przyjmuje próśb o teleportację.
""";

    private static final String TR = """
menu.title=Ayarlar
menu.on=AÇIK
menu.off=KAPALI
menu.currently=Şu an: %s
menu.toggle=Değiştirmek için tıkla
menu.close=Kapat
menu.language=Dil
menu.language.hint=Dilini değiştirmek için tıkla
lang.title=Dil
lang.selected=Seçili
lang.click=Seçmek için tıkla
lang.back=Geri
lang.changed=Dil %s olarak değiştirildi.
setting.all_chat.name=Tüm Sohbet Mesajları
setting.all_chat.desc=Oyuncu sohbetini ve giriş/çıkış, başarım ve ölüm mesajlarını gizlemek için kapat. Eklenti mesajları ve MOTD yine görünür. Hâlâ mesaj gönderebilirsin.
setting.public_chat.name=Genel Sohbet
setting.public_chat.desc=Diğer oyuncuların gönderdiği sohbet mesajlarını göster.
setting.join_quit.name=Giriş / Çıkış Mesajları
setting.join_quit.desc=Oyuncular girdiğinde veya çıktığında mesaj göster.
setting.tpa_requests.name=TPA İstekleri
setting.tpa_requests.desc=Diğer oyuncuların sana ışınlanma isteği göndermesine izin ver.
setting.advancements.name=Başarım Mesajları
setting.advancements.desc=Oyuncular başarım kazandığında mesaj göster.
setting.mention_sound.name=Bahsedilme Sesi
setting.mention_sound.desc=Biri sohbette adını söylediğinde ses çal.
msg.public_chat_hidden=Genel sohbet artık gizli. Tekrar açmak için /settings kullan.
msg.public_chat_blocked=Genel sohbeti kapattın. Tekrar açmak için /settings kullan.
msg.tpa_blocked=%s ışınlanma isteklerini kabul etmiyor.
""";

    private static final String JA = """
menu.title=設定
menu.on=オン
menu.off=オフ
menu.currently=現在: %s
menu.toggle=クリックで切り替え
menu.close=閉じる
menu.language=言語
menu.language.hint=クリックして言語を変更
lang.title=言語
lang.selected=選択中
lang.click=クリックして選択
lang.back=戻る
lang.changed=言語を %s に変更しました。
setting.all_chat.name=すべてのチャットメッセージ
setting.all_chat.desc=オフにすると、プレイヤーのチャットと参加/退出・進捗・死亡メッセージが非表示になります。プラグインのメッセージとMOTDは引き続き表示されます。メッセージの送信は可能です。
setting.public_chat.name=パブリックチャット
setting.public_chat.desc=他のプレイヤーのチャットメッセージを表示します。
setting.join_quit.name=参加/退出メッセージ
setting.join_quit.desc=プレイヤーの参加・退出時にメッセージを表示します。
setting.tpa_requests.name=TPAリクエスト
setting.tpa_requests.desc=他のプレイヤーからのテレポートリクエストを受け付けます。
setting.advancements.name=進捗メッセージ
setting.advancements.desc=プレイヤーが進捗を達成したときにメッセージを表示します。
setting.mention_sound.name=メンション音
setting.mention_sound.desc=チャットで自分の名前が呼ばれたときに音を鳴らします。
msg.public_chat_hidden=パブリックチャットを非表示にしました。再表示するには /settings を使ってください。
msg.public_chat_blocked=パブリックチャットがオフになっています。再度オンにするには /settings を使ってください。
msg.tpa_blocked=%s はテレポートリクエストを受け付けていません。
""";

    private static final String KO = """
menu.title=설정
menu.on=켜짐
menu.off=꺼짐
menu.currently=현재: %s
menu.toggle=클릭하여 전환
menu.close=닫기
menu.language=언어
menu.language.hint=클릭하여 언어 변경
lang.title=언어
lang.selected=선택됨
lang.click=클릭하여 선택
lang.back=뒤로
lang.changed=언어가 %s(으)로 변경되었습니다.
setting.all_chat.name=모든 채팅 메시지
setting.all_chat.desc=끄면 플레이어 채팅과 입장/퇴장, 발전 과제, 사망 메시지가 숨겨집니다. 플러그인 메시지와 MOTD는 계속 표시됩니다. 메시지는 계속 보낼 수 있습니다.
setting.public_chat.name=공개 채팅
setting.public_chat.desc=다른 플레이어가 보낸 채팅 메시지를 표시합니다.
setting.join_quit.name=입장/퇴장 메시지
setting.join_quit.desc=플레이어가 입장하거나 퇴장할 때 메시지를 표시합니다.
setting.tpa_requests.name=TPA 요청
setting.tpa_requests.desc=다른 플레이어가 나에게 순간이동 요청을 보낼 수 있게 합니다.
setting.advancements.name=발전 과제 메시지
setting.advancements.desc=플레이어가 발전 과제를 달성하면 메시지를 표시합니다.
setting.mention_sound.name=멘션 소리
setting.mention_sound.desc=채팅에서 누군가 내 이름을 말하면 소리를 재생합니다.
msg.public_chat_hidden=공개 채팅이 숨겨졌습니다. 다시 켜려면 /settings를 사용하세요.
msg.public_chat_blocked=공개 채팅이 꺼져 있습니다. 다시 켜려면 /settings를 사용하세요.
msg.tpa_blocked=%s 님은 순간이동 요청을 받지 않습니다.
""";

    private static final String ZH = """
menu.title=设置
menu.on=开
menu.off=关
menu.currently=当前：%s
menu.toggle=点击切换
menu.close=关闭
menu.language=语言
menu.language.hint=点击更改语言
lang.title=语言
lang.selected=已选择
lang.click=点击选择
lang.back=返回
lang.changed=语言已更改为 %s。
setting.all_chat.name=所有聊天消息
setting.all_chat.desc=关闭后将隐藏玩家聊天以及加入/退出、进度和死亡消息。插件消息和 MOTD 仍会显示。你仍然可以发送消息。
setting.public_chat.name=公共聊天
setting.public_chat.desc=显示其他玩家发送的聊天消息。
setting.join_quit.name=加入/退出消息
setting.join_quit.desc=玩家加入或退出时显示消息。
setting.tpa_requests.name=TPA 请求
setting.tpa_requests.desc=允许其他玩家向你发送传送请求。
setting.advancements.name=进度消息
setting.advancements.desc=玩家获得进度时显示消息。
setting.mention_sound.name=提及提示音
setting.mention_sound.desc=有人在聊天中提到你的名字时播放提示音。
msg.public_chat_hidden=公共聊天已隐藏。使用 /settings 可重新开启。
msg.public_chat_blocked=你已关闭公共聊天。使用 /settings 可重新开启。
msg.tpa_blocked=%s 不接受传送请求。
""";

    private static final String SV = """
menu.title=Inställningar
menu.on=PÅ
menu.off=AV
menu.currently=Just nu: %s
menu.toggle=Klicka för att växla
menu.close=Stäng
menu.language=Språk
menu.language.hint=Klicka för att ändra språk
lang.title=Språk
lang.selected=Vald
lang.click=Klicka för att välja
lang.back=Tillbaka
lang.changed=Språket ändrades till %s.
setting.all_chat.name=Alla chattmeddelanden
setting.all_chat.desc=Stäng av för att dölja spelarchatten samt meddelanden om att gå med/lämna, framsteg och dödsfall. Pluginmeddelanden och MOTD visas fortfarande. Du kan fortfarande skicka meddelanden.
setting.public_chat.name=Offentlig chatt
setting.public_chat.desc=Visa chattmeddelanden från andra spelare.
setting.join_quit.name=Anslutningsmeddelanden
setting.join_quit.desc=Visa meddelanden när spelare går med eller lämnar.
setting.tpa_requests.name=TPA-förfrågningar
setting.tpa_requests.desc=Låt andra spelare skicka teleporteringsförfrågningar till dig.
setting.advancements.name=Framstegsmeddelanden
setting.advancements.desc=Visa meddelanden när spelare får framsteg.
setting.mention_sound.name=Omnämnandeljud
setting.mention_sound.desc=Spela upp ett ljud när någon säger ditt namn i chatten.
msg.public_chat_hidden=Den offentliga chatten är nu dold. Använd /settings för att slå på den igen.
msg.public_chat_blocked=Du har stängt av den offentliga chatten. Använd /settings för att slå på den igen.
msg.tpa_blocked=%s tar inte emot teleporteringsförfrågningar.
""";

    private static final String DA = """
menu.title=Indstillinger
menu.on=TIL
menu.off=FRA
menu.currently=Lige nu: %s
menu.toggle=Klik for at skifte
menu.close=Luk
menu.language=Sprog
menu.language.hint=Klik for at ændre dit sprog
lang.title=Sprog
lang.selected=Valgt
lang.click=Klik for at vælge
lang.back=Tilbage
lang.changed=Sprog ændret til %s.
setting.all_chat.name=Alle chatbeskeder
setting.all_chat.desc=Slå fra for at skjule spillerchat samt beskeder om tilslutning/forladelse, fremskridt og dødsfald. Pluginbeskeder og MOTD vises stadig. Du kan stadig sende beskeder.
setting.public_chat.name=Offentlig chat
setting.public_chat.desc=Vis chatbeskeder fra andre spillere.
setting.join_quit.name=Tilslutningsbeskeder
setting.join_quit.desc=Vis beskeder, når spillere tilslutter sig eller forlader serveren.
setting.tpa_requests.name=TPA-anmodninger
setting.tpa_requests.desc=Lad andre spillere sende dig teleporteringsanmodninger.
setting.advancements.name=Fremskridtsbeskeder
setting.advancements.desc=Vis beskeder, når spillere opnår fremskridt.
setting.mention_sound.name=Omtalelyd
setting.mention_sound.desc=Afspil en lyd, når nogen siger dit navn i chatten.
msg.public_chat_hidden=Den offentlige chat er nu skjult. Brug /settings for at slå den til igen.
msg.public_chat_blocked=Du har slået den offentlige chat fra. Brug /settings for at slå den til igen.
msg.tpa_blocked=%s modtager ikke teleporteringsanmodninger.
""";

    private static final String FI = """
menu.title=Asetukset
menu.on=PÄÄLLÄ
menu.off=POIS
menu.currently=Nykyinen: %s
menu.toggle=Vaihda napsauttamalla
menu.close=Sulje
menu.language=Kieli
menu.language.hint=Vaihda kieltä napsauttamalla
lang.title=Kieli
lang.selected=Valittu
lang.click=Valitse napsauttamalla
lang.back=Takaisin
lang.changed=Kieleksi vaihdettiin %s.
setting.all_chat.name=Kaikki chat-viestit
setting.all_chat.desc=Poista käytöstä piilottaaksesi pelaajien chatin sekä liittymis-, edistysaskel- ja kuolemaviestit. Lisäosien viestit ja MOTD näkyvät silti. Voit edelleen lähettää viestejä.
setting.public_chat.name=Julkinen chat
setting.public_chat.desc=Näytä muiden pelaajien chat-viestit.
setting.join_quit.name=Liittymis- ja poistumisviestit
setting.join_quit.desc=Näytä viestit, kun pelaajat liittyvät tai poistuvat.
setting.tpa_requests.name=TPA-pyynnöt
setting.tpa_requests.desc=Salli muiden pelaajien lähettää sinulle teleporttipyyntöjä.
setting.advancements.name=Edistysaskelviestit
setting.advancements.desc=Näytä viestit, kun pelaajat saavuttavat edistysaskeleita.
setting.mention_sound.name=Maininta-ääni
setting.mention_sound.desc=Toista ääni, kun joku sanoo nimesi chatissa.
msg.public_chat_hidden=Julkinen chat on nyt piilotettu. Ota se takaisin käyttöön komennolla /settings.
msg.public_chat_blocked=Julkinen chat on poissa käytöstä. Ota se takaisin käyttöön komennolla /settings.
msg.tpa_blocked=%s ei ota vastaan teleporttipyyntöjä.
""";

    private static final String CS = """
menu.title=Nastavení
menu.on=ZAP
menu.off=VYP
menu.currently=Aktuálně: %s
menu.toggle=Kliknutím přepnete
menu.close=Zavřít
menu.language=Jazyk
menu.language.hint=Kliknutím změníte jazyk
lang.title=Jazyk
lang.selected=Vybráno
lang.click=Kliknutím vyberete
lang.back=Zpět
lang.changed=Jazyk byl změněn na %s.
setting.all_chat.name=Všechny zprávy chatu
setting.all_chat.desc=Vypnutím skryjete chat hráčů a zprávy o připojení/odpojení, úspěších a úmrtích. Zprávy pluginů a MOTD se stále zobrazují. Zprávy můžete dál posílat.
setting.public_chat.name=Veřejný chat
setting.public_chat.desc=Zobrazovat zprávy od ostatních hráčů.
setting.join_quit.name=Zprávy o připojení/odpojení
setting.join_quit.desc=Zobrazovat zprávy, když se hráči připojí nebo odpojí.
setting.tpa_requests.name=Žádosti o TPA
setting.tpa_requests.desc=Povolit ostatním hráčům posílat vám žádosti o teleportaci.
setting.advancements.name=Zprávy o úspěších
setting.advancements.desc=Zobrazovat zprávy, když hráči získají úspěch.
setting.mention_sound.name=Zvuk zmínky
setting.mention_sound.desc=Přehrát zvuk, když někdo v chatu řekne vaše jméno.
msg.public_chat_hidden=Veřejný chat je nyní skrytý. Znovu ho zapnete příkazem /settings.
msg.public_chat_blocked=Máte vypnutý veřejný chat. Znovu ho zapnete příkazem /settings.
msg.tpa_blocked=%s nepřijímá žádosti o teleportaci.
""";

    private static final String UK = """
menu.title=Налаштування
menu.on=УВІМК
menu.off=ВИМК
menu.currently=Зараз: %s
menu.toggle=Натисніть, щоб перемкнути
menu.close=Закрити
menu.language=Мова
menu.language.hint=Натисніть, щоб змінити мову
lang.title=Мова
lang.selected=Вибрано
lang.click=Натисніть, щоб вибрати
lang.back=Назад
lang.changed=Мову змінено на %s.
setting.all_chat.name=Усі повідомлення чату
setting.all_chat.desc=Вимкніть, щоб приховати чат гравців та повідомлення про вхід/вихід, досягнення і смерті. Повідомлення плагінів і MOTD і далі показуються. Ви все ще можете надсилати повідомлення.
setting.public_chat.name=Загальний чат
setting.public_chat.desc=Показувати повідомлення чату від інших гравців.
setting.join_quit.name=Повідомлення про вхід і вихід
setting.join_quit.desc=Показувати повідомлення, коли гравці заходять або виходять.
setting.tpa_requests.name=Запити TPA
setting.tpa_requests.desc=Дозволити іншим гравцям надсилати вам запити на телепортацію.
setting.advancements.name=Повідомлення про досягнення
setting.advancements.desc=Показувати повідомлення, коли гравці отримують досягнення.
setting.mention_sound.name=Звук згадки
setting.mention_sound.desc=Відтворювати звук, коли хтось називає ваше ім'я в чаті.
msg.public_chat_hidden=Загальний чат приховано. Використайте /settings, щоб увімкнути його знову.
msg.public_chat_blocked=У вас вимкнено загальний чат. Використайте /settings, щоб увімкнути його знову.
msg.tpa_blocked=%s не приймає запити на телепортацію.
""";

    private static final String ID = """
menu.title=Pengaturan
menu.on=AKTIF
menu.off=NONAKTIF
menu.currently=Saat ini: %s
menu.toggle=Klik untuk mengganti
menu.close=Tutup
menu.language=Bahasa
menu.language.hint=Klik untuk mengubah bahasamu
lang.title=Bahasa
lang.selected=Dipilih
lang.click=Klik untuk memilih
lang.back=Kembali
lang.changed=Bahasa diubah ke %s.
setting.all_chat.name=Semua Pesan Obrolan
setting.all_chat.desc=Matikan untuk menyembunyikan obrolan pemain serta pesan masuk/keluar, pencapaian, dan kematian. Pesan plugin dan MOTD tetap ditampilkan. Kamu tetap bisa mengirim pesan.
setting.public_chat.name=Obrolan Publik
setting.public_chat.desc=Tampilkan pesan obrolan dari pemain lain.
setting.join_quit.name=Pesan Masuk / Keluar
setting.join_quit.desc=Tampilkan pesan saat pemain masuk atau keluar.
setting.tpa_requests.name=Permintaan TPA
setting.tpa_requests.desc=Izinkan pemain lain mengirimimu permintaan teleportasi.
setting.advancements.name=Pesan Pencapaian
setting.advancements.desc=Tampilkan pesan saat pemain meraih pencapaian.
setting.mention_sound.name=Suara Sebutan
setting.mention_sound.desc=Mainkan suara saat seseorang menyebut namamu di obrolan.
msg.public_chat_hidden=Obrolan publik sekarang disembunyikan. Gunakan /settings untuk mengaktifkannya kembali.
msg.public_chat_blocked=Obrolan publik kamu nonaktif. Gunakan /settings untuk mengaktifkannya kembali.
msg.tpa_blocked=%s tidak menerima permintaan teleportasi.
""";

    private static final String VI = """
menu.title=Cài đặt
menu.on=BẬT
menu.off=TẮT
menu.currently=Hiện tại: %s
menu.toggle=Nhấp để bật/tắt
menu.close=Đóng
menu.language=Ngôn ngữ
menu.language.hint=Nhấp để đổi ngôn ngữ
lang.title=Ngôn ngữ
lang.selected=Đã chọn
lang.click=Nhấp để chọn
lang.back=Quay lại
lang.changed=Đã đổi ngôn ngữ sang %s.
setting.all_chat.name=Tất cả tin nhắn trò chuyện
setting.all_chat.desc=Tắt để ẩn trò chuyện của người chơi và tin nhắn vào/rời, thành tựu, tử vong. Tin nhắn của plugin và MOTD vẫn hiển thị. Bạn vẫn có thể gửi tin nhắn.
setting.public_chat.name=Trò chuyện công khai
setting.public_chat.desc=Hiển thị tin nhắn trò chuyện từ người chơi khác.
setting.join_quit.name=Tin nhắn vào/rời
setting.join_quit.desc=Hiển thị tin nhắn khi người chơi vào hoặc rời máy chủ.
setting.tpa_requests.name=Yêu cầu TPA
setting.tpa_requests.desc=Cho phép người chơi khác gửi yêu cầu dịch chuyển đến bạn.
setting.advancements.name=Tin nhắn thành tựu
setting.advancements.desc=Hiển thị tin nhắn khi người chơi đạt thành tựu.
setting.mention_sound.name=Âm thanh được nhắc tên
setting.mention_sound.desc=Phát âm thanh khi ai đó nhắc tên bạn trong trò chuyện.
msg.public_chat_hidden=Trò chuyện công khai đã bị ẩn. Dùng /settings để bật lại.
msg.public_chat_blocked=Bạn đã tắt trò chuyện công khai. Dùng /settings để bật lại.
msg.tpa_blocked=%s không nhận yêu cầu dịch chuyển.
""";

    private static final Map<Lang, Properties> TABLES = new EnumMap<>(Lang.class);

    static {
        register(Lang.EN, EN);
        register(Lang.ES, ES);
        register(Lang.FR, FR);
        register(Lang.DE, DE);
        register(Lang.PT, PT);
        register(Lang.IT, IT);
        register(Lang.NL, NL);
        register(Lang.RU, RU);
        register(Lang.PL, PL);
        register(Lang.TR, TR);
        register(Lang.JA, JA);
        register(Lang.KO, KO);
        register(Lang.ZH, ZH);
        register(Lang.SV, SV);
        register(Lang.DA, DA);
        register(Lang.FI, FI);
        register(Lang.CS, CS);
        register(Lang.UK, UK);
        register(Lang.ID, ID);
        register(Lang.VI, VI);
    }

    private Translations() {}

    private static void register(Lang lang, String text) {
        Properties props = new Properties();
        try {
            props.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalStateException("Bad translation table for " + lang, e);
        }
        TABLES.put(lang, props);
    }

    /** Looks up a translated string; falls back to English, then to the key itself. */
    public static String tr(Lang lang, String key, Object... args) {
        String text = TABLES.get(lang).getProperty(key);
        if (text == null) text = TABLES.get(Lang.EN).getProperty(key, key);
        return args.length == 0 ? text : String.format(text, args);
    }

    /** For testing: every key in the English table. */
    static Iterable<String> keys() {
        return TABLES.get(Lang.EN).stringPropertyNames();
    }

    static boolean has(Lang lang, String key) {
        return TABLES.get(lang).getProperty(key) != null;
    }
}
