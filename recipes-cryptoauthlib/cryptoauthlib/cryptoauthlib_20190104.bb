SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe for CryptoAuthLib https://github.com/MicrochipTech/cryptoauthlib"
LICENSE = "MIT"

SRC_URI = "https://github.com/MicrochipTech/cryptoauthlib/archive/${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

LIC_FILES_CHKSUM = "file://license.txt;md5=b5b48730d6f3c3c31c53274314051b47"

inherit distutils setuptools

do_install() {
	cd lib
    install -d ${D}/lib/${bindir}
    install -m 0755 cryptoauthlib ${D}${bindir}
}

SRC_URI[md5sum] = "123e566e4a6509f70cb09de50c172144"
SRC_URI[sha256sum] = "a5c02dd40a3e97297e0c06d539a11ca7544ce1231a2044d37d2adc64e8b85a6d"
