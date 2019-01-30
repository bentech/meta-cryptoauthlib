SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe for CryptoAuthLib https://github.com/MicrochipTech/cryptoauthlib"
LICENSE = "MIT"

PV = "20190124"

SRCREV = "9dbb3b76404ac32b52e9e46509775dd1bc1a4f70"
SRC_URI = "git://github.com/MicrochipTech/cryptoauthlib.git;branch=pkcs11"
SRC_URI[md5sum] = "ac317fa31493d2848ad7b35cbae9ce31"
SRC_URI[sha256sum] = "da1d45faf327d3328257de5588c42065b235c2eea19b729eb1bd7d6a297918bc"

LIC_FILES_CHKSUM = "file://../license.txt;md5=b5b48730d6f3c3c31c53274314051b47"

DEPENDS += "udev"

S = "${WORKDIR}/git/lib"

EXTRA_OECMAKE += "-DATCA_HAL_I2C=on -DATCA_PKCS11=on -DDEFAULT_LIB_PATH=/usr/lib"

inherit cmake

do_install() {
    install -d ${D}/usr/lib
    install -m 0755 ${WORKDIR}/build/libcryptoauth.so ${D}/usr/lib
}

FILES_${PN} = "/usr/lib/libcryptoauth.so"
FILES_${PN}-dev = ""
