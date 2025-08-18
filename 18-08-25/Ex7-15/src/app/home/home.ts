import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,   
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrls: ['./home.css']  
})
export class Home {
  books = [
    { title: "Book 1", description: "A classic American novel about the Jazz Age and the American Dream.", image: "https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=300&h=400&fit=crop" },
    { title: "Book 2", description: "A powerful story of racial injustice and childhood innocence.", image: "https://images.unsplash.com/photo-1481627834876-b7833e8f5570?w=300&h=400&fit=crop" },
    { title: "Book 3", description: "Orwell's dystopian masterpiece about totalitarianism and surveillance.", image: "https://images.unsplash.com/photo-1495640452828-3df6795cf69b?w=300&h=400&fit=crop" },
    { title: "Book 4", description: "Jane Austen's beloved romance about Elizabeth Bennet and Mr. Darcy.", image: "https://images.unsplash.com/photo-1512820790803-83ca734da794?w=300&h=400&fit=crop" },
    { title: "Book 5", description: "Salinger's coming-of-age story following Holden Caulfield.", image: "https://english-e-reader.net/covers/The_Catcher_in_the_Rye-Jerome_David_Salinger.jpg" },
    { title: "Book 6", description: "The magical beginning of Harry Potter's journey at Hogwarts.", image: "https://images.unsplash.com/photo-1621351183012-e2f9972dd9bf?w=300&h=400&fit=crop" },
    { title: "Book 7", description: "Tolkien's epic fantasy adventure through Middle-earth.", image: "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSYHuKZScdd6RHhzh-IDKga3wfTTd9cPEe1Y2JUI5gjvaxgJc3O" },
    { title: "Book 8", description: "Suzanne Collins' dystopian thriller about survival and rebellion.", image: "https://images.unsplash.com/photo-1589998059171-988d887df646?w=300&h=400&fit=crop" },
    { title: "Book 9", description: "Frank Herbert's science fiction epic set on desert planet Arrakis.", image: "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=300&h=400&fit=crop" },
    { title: "Book 10", description: "Margaret Atwood's chilling dystopian novel about women's rights.", image: "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=300&h=400&fit=crop" },
    { title: "Book 11", description: "Yuval Noah Harari's exploration of human history and evolution.", image: "https://images.unsplash.com/photo-1592496431122-2349e0fbc666?w=300&h=400&fit=crop" },
    { title: "Book 12", description: "Dan Brown's thrilling mystery involving art, history, and secrets.", image: "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSH6K2-nGoy-x6jSfx63ELwiAEYfvg9OkPNHoKPKPcoJRoc789O" },
    { title: "Book 13", description: "Bilbo Baggins' unexpected journey to the Lonely Mountain.", image: "https://images.unsplash.com/photo-1518373714866-3f1478910cc0?w=300&h=400&fit=crop" },
    { title: "Book 14", description: "Aldous Huxley's vision of a future society controlled by technology.", image: "https://images.unsplash.com/photo-1497633762265-9d179a990aa6?w=300&h=400&fit=crop" },
    { title: "Book 15", description: "Paulo Coelho's inspiring tale about following your dreams.", image: "https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=300&h=400&fit=crop" },
    { title: "Book 16", description: "Gillian Flynn's psychological thriller about a missing wife.", image: "https://images.unsplash.com/photo-1515879218367-8466d910aaa4?w=300&h=400&fit=crop" },
    { title: "Book 17", description: "Stieg Larsson's gripping crime thriller from Sweden.", image: "https://images.unsplash.com/photo-1481627834876-b7833e8f5570?w=300&h=400&fit=crop" },
    { title: "Book 18", description: "Yann Martel's extraordinary tale of survival at sea.", image: "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=300&h=400&fit=crop" },
    { title: "Book 19", description: "Khaled Hosseini's powerful story of friendship and redemption.", image: "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=300&h=400&fit=crop" },
    { title: "Book 20", description: "Tara Westover's memoir about education and family transformation.", image: "https://images.unsplash.com/photo-1592496431122-2349e0fbc666?w=300&h=400&fit=crop" }
  ];
}
