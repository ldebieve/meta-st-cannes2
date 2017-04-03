FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_stih410-b2260 = " file://asound.conf  \
            file://sti_audio_card.conf"

SRC_URI_append_st-xenomai = " file://asound.conf  \
            file://sti_audio_card.conf"

do_install_append_stih410-b2260() {
   install -d  ${D}/etc/
   install -m 0644 ${WORKDIR}/asound.conf ${D}/etc/

   install -d ${D}/usr -d ${D}/usr/share
   install -d ${D}/usr/share/alsa -d ${D}/usr/share/alsa/cards
   install -m 0644 ${WORKDIR}/sti_audio_card.conf ${D}/usr/share/alsa/cards/
}

do_install_append_st-xenomai() {
   install -d  ${D}/etc/
   install -m 0644 ${WORKDIR}/asound.conf ${D}/etc/

   install -d ${D}/usr -d ${D}/usr/share
   install -d ${D}/usr/share/alsa -d ${D}/usr/share/alsa/cards
   install -m 0644 ${WORKDIR}/sti_audio_card.conf ${D}/usr/share/alsa/cards/
}

FILES_alsa-conf-base_append_stih410-b2260 = " ${sysconfdir}/asound.conf ${datadir}/alsa/cards/sti_audio_card.conf"

FILES_alsa-conf-base_append_st-xenomai = " ${sysconfdir}/asound.conf ${datadir}/alsa/cards/sti_audio_card.conf"

