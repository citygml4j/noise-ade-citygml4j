@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Windows start script for converting the NoiseADE
@rem
@rem ##########################################################################

set OUTPUT="src-gen"
set PACKAGE="org.citygml.ade.noise_de._2"
set BINDING="binding.xjb"
set SCHEMA="CityGML-NoiseADE.xsd"
set PLUGINS="-Xnamespace-prefix"

call ..\ade-xjc.bat %PLUGINS% -clean -output %OUTPUT% -package %PACKAGE% -binding %BINDING% %SCHEMA%