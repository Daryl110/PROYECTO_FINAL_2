--traer el valor de los comparendos de la persona
SELECT (SELECT V.VALOR_SALARIO_MINIMO FROM Valores V)*TF.Salarios_Minimos,C.Id FROM Tipo_Infraccion TF JOIN Comparendo C ON(C.Tipo_Infraccion_Codigo=TF.Codigo)
JOIN Persona P ON(P.Nip=C.Infractor) WHERE P.Nip=&ID;