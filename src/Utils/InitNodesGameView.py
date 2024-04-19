
size = 16

for indexI in range(size):
    for indexJ in range(size):
        print(f"""<Button fx:id="node_{indexI}_{indexJ}" mnemonicParsing="false" text="{indexI}_{indexJ}" GridPane.rowIndex="{indexI}" GridPane.columnIndex="{indexJ}"><styleClass><String fx:value="textNumberGame" /><String fx:value="numberGame" /></styleClass></Button>""")


