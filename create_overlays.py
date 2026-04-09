from PIL import Image
import os

# Пути к папкам
base_path = r"C:\Users\n4471\OneDrive\Документы\My_mods\Ultimate Tech\src\main\resources\assets\ultimate_tech\textures\item"
tool_types = ["sword", "pickaxe", "axe", "shovel", "hoe"]

# Создаём белые текстуры 16x16 для каждого типа инструмента
for tool_type in tool_types:
    img = Image.new('RGBA', (16, 16), (255, 255, 255, 255))  # Белая полностью непрозрачная текстура
    output_path = os.path.join(base_path, tool_type, "overlay.png")
    img.save(output_path)
    print(f"Created: {output_path}")

print("Все overlay текстуры созданы!")

