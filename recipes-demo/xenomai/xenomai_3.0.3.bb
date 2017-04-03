SUMMARY = "Xenomai"
HOMEPAGE = "https://xenomai.org/"
SECTION = "libs"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://include/COPYING;md5=79ed705ccb9481bf9e7026b99f4e2b0e"

inherit autotools pkgconfig

SRC_URI = "https://xenomai.org/downloads/${BPN}/stable/${BPN}-${PV}.tar.bz2;name=tarball"
SRC_URI[tarball.md5sum] = "fed85fa0c07bbb11e8357ac056920f8b"
SRC_URI[tarball.sha256sum] = "4c396b4d447efd414c4d7c0894f97ef52b4ec45c87f512c14adee981a45f0e3b"

SRC_URI_append_st-xenomai = " \
    file://0001-Solve-build-issue-because-of-warning.patch "

FILES_${PN} += "/dev/rtp*"
FILES_${PN} += "${libdir}/dynlist.ld"
FILES_${PN} += "${libdir}/cobalt.wrappers"
FILES_${PN} += "${exec_prefix}/demo/*"
FILES_${PN}-dev += "${prefix}/*.h"
FILES_${PN}-dev += "${prefix}/*/*.h"
FILES_${PN}-dev += "${prefix}/*/*/*.h"
FILES_${PN}-dev += "${prefix}/*/*/*/*.h"
FILES_${PN}-dbg += "${exec_prefix}/demo/.debug/*"

#EXTRA_OECONF += "CFLAGS="-march=armv7-a -mfpu=vfp" LDFLAGS="-march=armv7-a -mfpu=vfp" --with-core=cobalt --enable-smp --includedir=${prefix}"
EXTRA_OECONF += "--with-core=cobalt --enable-smp --includedir=${prefix}"
