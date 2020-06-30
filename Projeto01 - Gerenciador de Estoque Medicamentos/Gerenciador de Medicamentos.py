#Trabalho de Grau A - Status: Pronto - Revisado em 29/04

cadastroMed = [[1, 'Tylenol', 'Paracetamol', 65.85, 100, 0], [2, 'Rivotril','Clonazepam', 115.25, 350, 1], [5, "Advil", "Isobutilfenilpropanóico", 3.55, 250, 2], [8, 'Aspirina', "Acido Acetilsalicílico", 25.95, 500, 3], [4, 'Bromazepam', 'Benzodiazepínica', 50.85, 315, 0], [7, 'Cloroquina', 'Hidroxicloroquina', 49.95, 1000, 4], [11, 'Loratadina', 'Piperidinecarboxylate', 9.95, 165, 5]]

listaMed = []

cadastroFabricante = [[0, "Apsen"], [1, "Bayer"], [2, "Delta"], [3, "Hertz"], [4, "Medley"],[5, "Pfzer"]]

listaFabricante = []

cadastroVenda = [[2, 100] , [5, 150] , [4, 175] , [1 , 400] , [4, 85] , [1, 1500], [11, 290]]

listaVenda = []

################################################################################

def menuEstoque(): 
  print('1 - [Mostrar todo o estoque]')
  print('2 - [Filtrar estoque]')
  print('3 - [Voltar ao menu principal]')
  print()
  
  ehNumero = False
  while not ehNumero:
    try:
      novaOpcao = int(input('Digite uma opção: '))
      
      if novaOpcao < 0:
        print('Por favor, digite um valor conforme o menu [1, 2 ou 3]:')

      else:
        ehNumero = True

    except:
      print('Por favor, digite um valor conforme o menu [1, 2 ou 3]:')      
 
  if novaOpcao == 1:
    print()
    mostraEstoqueCompleto()
    
  elif novaOpcao == 2:
    print()
    mostraEstoqueFiltrado()

  else:
    print()
    return  

################################################################################  

def mostraEstoqueCompleto():
  print()
  print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')
  
  for cadaRemedio in cadastroMed:
    for cadaCampo in cadaRemedio:
      print(cadaCampo, "| ", end='')
    print()
  print()

  tecla = input("Digite qualquer tecla para voltar: ")
  
  if tecla or not tecla:
    print()
    print('--------------------------------------------------------------------')
    return

################################################################################

def mostraEstoqueFiltrado():
  print('1 - [Filtrar por Codigo]')
  print('2 - [Por Preço Unitário]')
  print('3 - [Por Quantidade]')
  print('4 - [Por Codigo do Fabricante]')
  print('5 - [Voltar ao Menu Anterior]')
  print()
  
  opcaoValida = False
  while not opcaoValida:
    try:
      filtro = int(input("Escolha sua opção: "))

      if filtro <= 0:
        print("Opcão inválida!")

      else:
        opcaoValida = True

    except:
      print('Opcão inválida!')    

  if filtro == 1:
    print()
    intervalosOK = False
    while not intervalosOK:
      try:
        min = int(input('Digite o intervalo inferior do código do medicamento: '))  

        while min < 0:
          print("Você não pode digitar um intervalo negativo.")
          min = int(input('Digite o intervalo inferior do código do medicamento: '))  
        intervalosOK = True   

      except:
        print("Valor inválido.")
       
    intervalosOK = False
    while not intervalosOK:
      try: 
        max = int(input('Digite o intervalo superior do código do medicamento: ')) 

        while max <= min:
          print("Você não pode digitar um intervalo superior menor que o inferior.")
          max = int(input('Digite o intervalo superior do código do medicamento: '))         

        intervalosOK = True

        print()  
        print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')

        for cadaRemedio in cadastroMed:
          if cadaRemedio[0] >= min and cadaRemedio[0] <= max:
            for cadaCampo in cadaRemedio:
              print(cadaCampo, "| ", end='')
            print()
        print()      
        print('--------------------------------------------------------------------')
        return

      except:
        print("Valor inválido.")       

  elif filtro == 2:
    print()
    intervalosOK = False
    while not intervalosOK:
      try:
        min = float(input('Digite o intervalo inferior do preço do medicamento: '))  

        while min < 0:
          print("Você não pode digitar um intervalo negativo.")
          min = float(input('Digite o intervalo inferior do preço do medicamento: '))  
        intervalosOK = True   

      except:
        print("Valor inválido.")
       
    intervalosOK = False
    while not intervalosOK:
      try: 
        max = float(input('Digite o intervalo superior do preço do medicamento: ')) 

        while max <= min:
          print("Você não pode digitar um intervalo superior menor que o inferior.")
          max = float(input('Digite o intervalo superior do preço do medicamento: '))         

        intervalosOK = True 

        print()
        print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')
        for cadaRemedio in cadastroMed:
          if cadaRemedio[3] >= min and cadaRemedio[3] <= max:
            for cadaCampo in cadaRemedio:
              print(cadaCampo, "| ", end ="")
            print()
        print('--------------------------------------------------------------------')
        return

      except:
        print("Valor inválido.")

  elif filtro == 3:
    print()
    intervalosOK = False
    while not intervalosOK:
      try:
        min = int(input('Digite o intervalo inferior da quantidade do medicamento: '))  

        while min < 0:
          print("Você não pode digitar um intervalo negativo.")
          min = int(input('Digite o intervalo inferior da quantidade do medicamento: '))  
        intervalosOK = True   

      except:
        print("Valor inválido.")
       
    intervalosOK = False
    while not intervalosOK:
      try: 
        max = int(input('Digite o intervalo superior da quantidade do medicamento: ')) 

        while max <= min:
          print("Você não pode digitar um intervalo superior menor que o inferior.")
          max = int(input('Digite o intervalo superior da quantidade do medicamento: '))         

        intervalosOK = True 

        print()
        print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')
        for cadaRemedio in cadastroMed:
          if cadaRemedio[4] >= min and cadaRemedio[4] <= max:
            for cadaCampo in cadaRemedio:
              print(cadaCampo, "| ", end ="")
            print()
        print('--------------------------------------------------------------------')
        return

      except:
        print("Valor inválido.")
  
  elif filtro == 4:
    print()
    intervalosOK = False
    while not intervalosOK:
      try:
        min = int(input('Digite o intervalo inferior do código do fabricante do medicamento: '))  

        while min < 0:
          print("Você não pode digitar um intervalo negativo.")
          min = int(input('Digite o intervalo inferior do código do fabricante do medicamento: '))  
        intervalosOK = True   

      except:
        print("Valor inválido.")
       
    intervalosOK = False
    while not intervalosOK:
      try: 
        max = int(input('Digite o intervalo superior do código do fabricante do medicamento: ')) 

        while max <= min:
          print("Você não pode digitar um intervalo superior menor que o inferior.")
          max = int(input('Digite o intervalo superior do código do fabricante do medicamento: '))         

        intervalosOK = True 

        print()
        print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')
        for cadaRemedio in cadastroMed:
          if cadaRemedio[5] >= min and cadaRemedio[5] <= max:
            for cadaCampo in cadaRemedio:
              print(cadaCampo, "| ", end ="")
            print()
        print('--------------------------------------------------------------------')
        return

      except:
        print("Valor inválido.")
  
  else:
    print('--------------------------------------------------------------------')
    return

################################################################################

def estoqueSimplificado():
  print()
  print('Cod | Nome |')
  for cadaRemedio in cadastroMed:
    i = 0
    for cadaCampo in cadaRemedio:
      print(cadaCampo, "| ", end='')
      i = i + 1
      if i > 1:
        break  
    print()
  print()  

################################################################################

def addMed(): 
  while True:

    codigoExiste = True

    try:
      codigoRemed = int(input('Digite o código do medicamento: '))
      
      while codigoExiste:
        codigoExiste = False

        for i in range(0, len(cadastroMed)):
          if codigoRemed == cadastroMed[i][0] or codigoRemed < 0:
            codigoExiste = True
            print("Codigo inválido ou já cadastrado, por favor digite outro!")
            codigoRemed = int(input('Digite o código do medicamento: '))

      else:
        break

    except:
      print("Código inválido.")  
 
  listaMed.append(codigoRemed)
  
  jahExiste = True
  nomeRemed = input('Digite o nome do medicamento: ')

  while not nomeRemed:
    print("Nome inválido.")
    nomeRemed = input('Digite o nome do medicamento: ')

  while jahExiste:
    jahExiste = False
    for i in range(0, len(cadastroMed)):
      if nomeRemed.title() == cadastroMed[i][1]:
        jahExiste = True
        print("Nome de remédio já cadastrado, por favor cadastre outro!")
        nomeRemed = input('Digite o nome do medicamento: ')

        while not nomeRemed:
          print("Nome inválido.")
          nomeRemed = input('Digite o nome do medicamento: ')
         
  listaMed.append(nomeRemed.title())
 
  pAtivo = input('Digite o princípio ativo: ')

  while not pAtivo:
    print("Texto inválido.")
    pAtivo = input('Digite o princípio ativo: ')

  pAtivo = pAtivo.title()
  
  listaMed.append(pAtivo)

  precoValido = True
  while precoValido:

    try:
      preco = float(input('Digite o preço do medicamento: '))

      if preco <= 0:
        print("O preço do produto não pode ser negativo nem zero.")

      else:
        precoValido = False
        
    except:
      print("Este valor não é um preço válido.")

  listaMed.append(preco)

  qtdValida = True
  while qtdValida:
    try:
      qtd = int(input('Digite a quantidade do medicamento: '))

      if qtd <= 0:
        print("Não pode haver uma quantidade negativa ou igual a zero.")

      else:
        listaMed.append(qtd)
        qtdValida = False

    except:
      print("Esta não é uma quantidade válida!")  
  

  codigoValido = True
  print('\n''Segue lista de fabricantes cadastrados:''\n')
  print('Cod | Nome do Fabricante')  
  for cadaFabricante in cadastroFabricante:
    for cadaCampo in cadaFabricante:
      print(cadaCampo, "| ",end ='')
    print()

  while codigoValido:      
    try:       
        print()
        codFabricante = int(input('Digite o código de algum fabricante: '))

        for i in range(0, len(cadastroFabricante)):
          if codFabricante == cadastroFabricante[i][0]:
            codigoValido = False

        if codigoValido:
          print("Código de fabricante não cadastrado.")
          
        else: 
          listaMed.append(codFabricante)

    except:
      print("Este não é um código válido!")

  cadastroMed.append(listaMed.copy())

  listaMed.clear()

  print('\n'"Medicamento cadastrado com sucesso!")
  print()
  print("Segue a lista atualizada do estoque:")
  mostraEstoqueCompleto()

################################################################################

def removerMedicamento():
  print('1 - [Remover um medicamento a partir do seu código]')
  print('2 - [Remover todos os medicamentos de um fabricante]')
  print('3 - [Voltar para o menu anterior]')
  print()

  selecao = True
  while selecao:
    try:
      escolha = int(input('Digite uma opção do menu: '))
      if escolha <= 0:
        print("Opção inválida!")

      elif escolha == 1:
        medJahExiste = True
        while medJahExiste:
          try:
            remover = int(input("Digite o código do remédio a ser removido: "))

            if remover < 0:
              print('Esta opção não é válida.')
              
            else:
              for i in range(0, len(cadastroMed)):
                if remover == cadastroMed[i][0]:
                  cadastroMed.pop(i)
                  print()
                  print("Medicamento removido do estoque!")
                  selecao = False
                  medJahExiste = False
                  break
              else:
                print("Código de medicamento não encontrado!")

          except:
            print('Opcão inválida.')
     
      elif escolha == 2:
        lista_temporaria = []
        removeFabricante = True
        while removeFabricante:
          try:
            removerFab = int(input("Digite o código do fabricante: "))
            if removerFab < 0:
              print("Código inválido.")
            else:
              existeFabricante = False
              for i in range(0, len(cadastroMed)): 
                if removerFab == cadastroMed[i][5]:
                  existeFabricante = True
                  lista_temporaria.append(i)
              if not existeFabricante:
                print("Código de fabricante não cadastrado.")
              else:                
                lista_temporaria.reverse()
                print()
                print("Os medicamentos abaixo foram excluídos do estoque!")
                print()
                print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')
                for i in range(0, len(lista_temporaria)):
                  print(cadastroMed[lista_temporaria[i]])
                  del cadastroMed[lista_temporaria[i]]
                lista_temporaria.clear()  
                removeFabricante = False
                selecao = False            
                    
          except:
            print("Digite um código de fabricante válido.")      
     
      else:
        return

    except:
      print('Opcão inválida!!')

  print()    
  print('Segue relação atualizada do estoque:')
  return

################################################################################

def venderMedicamento():
  print('1 - [Vender um medicamento]')
  print('2 - [Retornar ao menu anterior]')
  print()
  vendaOk = True
  while vendaOk:
    try:
      opcao = int(input("Digite uma opção do menu: "))   
     
      if opcao <= 0:
        print('Opção inválida!')    

      elif opcao == 1:        
      
        while len(listaVenda) == 0:
          try:
            codigoVenda = int(input("Digite o codigo do medicamento: "))

            for i in range(0, len(cadastroMed)):
              if codigoVenda == cadastroMed[i][0]:
                print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')
                print(cadastroMed[i])
                listaVenda.append(codigoVenda)

            if len(listaVenda) == 0:
              print("Código de medicamento não cadastrado.")

          except:
            print("Código inválido.")  
                                             
        quantidadeOK = True
        while quantidadeOK:
          for i in range(0, len(cadastroMed)):
            if codigoVenda == cadastroMed[i][0]:               
              print()
              print("Quantidade disponivel:", cadastroMed[i][4])
              print()
              
              try: 
                quantidadeVendida = int(input("Digite a quantidade a ser vendida: "))
          
                if quantidadeVendida > cadastroMed[i][4] or quantidadeVendida <= 0:
                  print("Quantidade inválida.")            
            
                else:
                  estoqueAtualizado = cadastroMed[i][4] - quantidadeVendida
                  cadastroMed[i][4] = estoqueAtualizado
                  print()
                  print("ESTOQUE ATUALIZADO")
                  print('Cod | Nome | PrincípioAtivo | Preço | Qtd | CódigoFabricante:')
                  for cadaRemedio in cadastroMed:
                    for cadaCampo in cadaRemedio:
                      print(cadaCampo, "| ", end='')
                    print()
                  print()
                  print("VENDAS TOTAIS ATÉ AGORA:")
                  print('Cod | Quantidade Vendida')

                  listaVenda.append(quantidadeVendida)
                  cadastroVenda.append(listaVenda.copy())   
                  listaVenda.clear()
                  
                  for cadaRemedio in cadastroVenda:
                    for cadaCampo in cadaRemedio:
                      print(cadaCampo, "| ", end = '')
                    print()
                  vendaOk = False
                  quantidadeOK = False
                  print()
              except:
                print("Quantidade inválida.")
      else:
        print()
        return
    except:
      print("Opção inválida. Escolha uma opção do Menu.")

  print()
  return

################################################################################

def cadastrarFabricante():
  print('1 - [Cadastrar novo Fabricante]')
  print('2 - [Retornar ao menu anterior]')
  print()

  tudoCerto = True
  while tudoCerto:

    try:
      option = int(input("Digite a opção desejada: "))

      if option <= 0:
        print("Opção inválida.")

      elif option == 1:        
        while True:
          try:
            codJahExiste = True
            novo_fabricante = int(input("Digite um código para o novo fabricante: "))

            while novo_fabricante < 0:
              print("Código inválido.")
              novo_fabricante = int(input("Digite um código para o novo fabricante: "))

            while codJahExiste:
              codJahExiste = False
              for i in range(0, len(cadastroFabricante)):
                if novo_fabricante == cadastroFabricante[i][0] or novo_fabricante < 0:
                  codJahExiste = True
                  print("Código de Fabricante já cadastrado ou inválido.")
                  novo_fabricante = int(input("Digite um código para o novo fabricante: "))   

            listaFabricante.append(novo_fabricante)
           
            nomeJahExiste = True
            novo_nome = input("Digite o nome do fabricante: ")               
            while nomeJahExiste:
              nomeJahExiste = False 
              for i in range(0, len(cadastroFabricante)):
                if novo_nome.title() == cadastroFabricante[i][1] or not novo_nome or novo_nome.isspace():
                  nomeJahExiste = True
                  print("Nome de Fabricante já cadastrado ou inválido.")
                  novo_nome = input("Digite o nome do fabricante: ")                
            
            listaFabricante.append(novo_nome.title())
            cadastroFabricante.append(listaFabricante.copy())
            listaFabricante.clear()
            print('\n'"Fabricante cadastrado com sucesso!")
            print()
            todosFabricantes()
            print()
            mostraMenu()
            tudoCerto = False

          except:
            print("Código inválido.")

      else:
        print()
        return

    except:
      print("Opção inválida.")

################################################################################

def removerFabricante(): 
  deuErrado = True
  while deuErrado:  

    try:
      print('1 - [Remover Fabricante]')
      print('2 - [Retornar ao menu anterior]')
      option = int(input('\n'"Digite uma opção: "))

      if option <= 0:
        print()
        print("Opção inválida!")

      elif option == 1:
        fabricanteExiste = True

        while fabricanteExiste:

          fabricanteExiste = False
          print()
          print('Segue lista de fabricantes cadastrados:''\n')
          print('Cod | Nome do Fabricante')
          for cadaFabricante in cadastroFabricante:
            for cadaCampo in cadaFabricante:
              print(cadaCampo, "| ",end ='')
            print()
          print()          
        
          codFabricante = int(input("Digite o código do Fabricante que será removido: "))
          print()          
          
          while codFabricante < 0:
            print("Código inválido.")
            print()
            print('Segue lista de fabricantes cadastrados:''\n')
            print('Cod | Nome do Fabricante')
            for cadaFabricante in cadastroFabricante:
              for cadaCampo in cadaFabricante:
                print(cadaCampo, "| ",end ='')
              print()
            print()
            codFabricante = int(input("Digite o código do Fabricante que será removido: "))
            fabricanteExiste = True        
                      
          for i in range (0, len(cadastroFabricante)):
            if codFabricante == cadastroFabricante[i][0]:
              del cadastroFabricante[i]
              break

          else:
            print("Código de fabricante não encontrado.") 
            fabricanteExiste = True
          
        for i in range(0, len(cadastroMed)):
          if codFabricante == cadastroMed[i][5]:
            listaFabricante.append(i)
                      
        listaFabricante.reverse()

        for i in range(0, len(listaFabricante)):
          del cadastroMed[listaFabricante[i]]          

        listaFabricante.clear()

        print("Fabricante removido com sucesso!"'\n')

        deuErrado = False

        print('Segue lista de fabricantes atualizados:''\n')
        print('Cod | Nome do Fabricante')
        for cadaFabricante in cadastroFabricante:
          for cadaCampo in cadaFabricante:
            print(cadaCampo, "| ",end ='')
          print()

        print('\n''ESTOQUE ATUALIZADO:')
        mostraEstoqueCompleto()
         
      else:
        print()
        return   
       
    except:
      print()
      print("Opção ou Código inválido. Recomece a remoção."'\n')

################################################################################

def todosFabricantes():
  print('Segue lista de fabricantes cadastrados:''\n')
  print('Cod | Nome do Fabricante')

  for cadaFabricante in cadastroFabricante:
    for cadaCampo in cadaFabricante:
      print(cadaCampo, "| ",end ='')
    print()

  tecla = input('\n'"Digite qualquer tecla para voltar: ")

  if tecla or not tecla:
    print()
    print('--------------------------------------------------------------------''\n')
    return    

################################################################################

def relatorioVendas():
  
  print('1 - [Gerar Relatorio de Vendas]')
  print('2 - [Retornar ao menu anterior]')
  print()

  relatorioOK = True
  while relatorioOK:
    try:
      opcao = int(input("Digite a opcao que deseja: "))

      if opcao == 1:
        print('\n''Segue relatório de vendas até o momento:')
        print()
        print("Cod | Nome | Quantidade | Valor da Venda") 

        totalVendido = 0 

        for i in range(0, len(cadastroMed)):         
          vendeu = False
          somatorio = 0
          quantidade = 0       

          for j in range(0, len(cadastroVenda)):

            if cadastroMed[i][0] == cadastroVenda[j][0]:             
              vendeu = True
              somatorio = somatorio + (cadastroMed[i][3] * cadastroVenda[j][1])
              quantidade = quantidade + cadastroVenda[j][1]
              totalVendido = totalVendido + somatorio
        
          if vendeu:                                
            print(cadastroMed[i][0], "|", cadastroMed[i][1], "|" , quantidade, "|", "R$",arredondar(somatorio))

        print('\n''O valor total de todas as vendas até o momento é de R$',arredondar(totalVendido))

      elif opcao == 2:
        print()
        return
      relatorioOK = False

    except:
      print()
      print("Digite uma opção válida.")
      print()

  else:
    print()
    tecla = input("Digite qualquer coisa para voltar ao menu anterior: ")

    if tecla or not tecla:
      print()
      return     
    
###############################################################################

def arredondar(num):
  return ('%.2f' %(num))
                    
###############################################################################

def mostraMenu():
  looping = True
  while looping:
    print('Menu:')
    print('1 - [Mostrar estoque de medicamentos]')
    print('2 - [Cadastrar novo medicamento]')
    print('3 - [Remover medicamento]')
    print('4 - [Vender Medicamento]')
    print('5 - [Cadastrar novo fabricante]')
    print('6 - [Remover fabricante]')
    print('7 - [Mostrar cadastro de fabricantes]')
    print('8 - [Relatório de Vendas]')
    print('9 - [Para sair do programa]')
    try:
      print()
      opcao = int(input('Escolha uma opção [1 a 9]: '))

      if opcao <= 0:
        print("Digite uma opção válida.")
        
      elif opcao == 1:
        print()
        menuEstoque()
      
      elif opcao == 2:
        print()
        addMed()
      
      elif opcao == 3:
        print()
        removerMedicamento()

      elif opcao == 4:
        print()
        venderMedicamento()

      elif opcao == 5:
        print()
        cadastrarFabricante()

      elif opcao == 6:
        print()
        removerFabricante()

      elif opcao == 7:
        print()
        todosFabricantes()

      elif opcao == 8:
        print()
        relatorioVendas()

      elif opcao == 9:
        looping = False
        print()
        print("PROGRAMA ENCERRADO. BY LionelWESTT CORPORATION ENTERPRISES ™ ©")        

    except:
      print("\nDigite uma opção válida.""\n")   
    
###############################################################################
mostraMenu()