const express = require('express');
const fs = require('fs');
const path = require('path'); // 👈 MUST ADD THIS AT THE TOP

const app = express();
const PORT = 3000;

// Serve static files from root directory
app.use(express.static(__dirname));

// Explicitly serve images from the images directory
app.use('/images', express.static(path.join(__dirname, 'images')));

// API endpoint to get images
app.get('/api/images', (req, res) => {
    const imagesDir = path.join(__dirname, 'images');
    
    fs.readdir(imagesDir, (err, files) => {
        if (err) {
            console.error("Error reading directory:", err);
            return res.status(500).json({ error: 'Unable to scan directory' });
        }
        
        const imageFiles = files.filter(file => 
            ['.jpg', '.jpeg', '.png', '.gif'].includes(path.extname(file).toLowerCase())
        );
        
        res.json({ images: imageFiles });
    });
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});